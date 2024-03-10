//Time Complexity - O(n*logn);

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }
            pq.add(end);
        }

        return pq.peek();
    }
}
