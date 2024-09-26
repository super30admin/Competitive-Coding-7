/* Time Complexity :O(nlogn)
 * Space Complexity :O(k)
 * Did this code successfully run on Leetcode :yes
 * Any problem you faced while coding this :No
*/

import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // null case
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // PQ of End Times
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        pq.add(intervals[0][1]); // End Time of First meeting
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                // check if start time of next meeting is greater than end time of current meeting
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}