// Approach:
// 1. Sort the given array on basis of meeting start times
// 2. Create a Min heap of End times of meetings (so that the 'earliest to end'' meeting is always on the top of heap). Insert the 1st meeting end time
// 3. For all other meetings left, check if the start time is >= end time of heap's top element
// If yes, poll(): remove that element from the heap
// 4. Add the new meeting end time in the heap regardless of above condition
// 5. Finally return the heap size as that is the No. of rooms required

// Time: O(n*logn) because heapify can happen for all n elements in worst case
// Space: O(n) for the min heap

import java.util.*;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // base case
        if (intervals.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        pq.add(intervals[0][1]);

        for (int i = 1; i<intervals.length; i++) {

            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}