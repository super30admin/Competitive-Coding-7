// Time Complexity :  nlogn for sorting nlogm in pq
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import java.util.Arrays;
import java.util.PriorityQueue;

public class Meetingroom {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Meetingroom solution = new Meetingroom();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int minRooms = solution.minMeetingRooms(intervals);

        System.out.println("Minimum meeting rooms required: " + minRooms);
    }
}
