// Time Complexity: O(nlogn) n - no. of intervals
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int rooms = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (pq.peek() == null || intervals[i][0] < pq.peek())
                rooms++;
            else {
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }

        return rooms;

    }
}