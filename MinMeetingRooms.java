import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(nlogn)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }

                heap.offer(itv[1]);
            }
        }

        return count;
    }
}
