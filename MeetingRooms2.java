// Time Complexity : O(nlogn) where n = number of elements in intervals matrix
// Space Complexity : O(k) where k = maximum size of heap
// 253. Meeting Rooms II (Medium) - https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    static class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // make minHeap based on end time of all meetings from intervals array
            pq.add(intervals[0][1]);

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= pq.peek()) {
                    pq.poll();
                }
                pq.add(intervals[i][1]);
            }

            return pq.size();
        }
    }
}
