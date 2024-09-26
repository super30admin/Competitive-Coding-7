import java.util.Arrays;
import java.util.PriorityQueue;

//Time complexity: O(nlogn)
//space complexity: O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return -1;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // sorting the input based on the start times in
                                                                       // order to compare.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty()) {
                if (pq.peek() <= intervals[i][0]) { // comparing if current end time is smaller than next meeting's
                                                    // start time-> if so they dont collide
                    pq.poll();
                }
            }
            pq.add(intervals[i][1]); // adding the end timings into the heap
        }
        return pq.size();

    }
}