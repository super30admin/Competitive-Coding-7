// https://leetcode.com/problems/meeting-rooms-ii/

// Time Complexity : O(n), where n is length of the array.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, initially add intervals[0][1] into priorityQueue then traverse along the intervals from index 1 and check if intervals[i][0]
 * is greaterthan or equal to pq.peek() if yes do pq.poll(). In all cases add pq.add(intervals[i][1]). Finally return pq.size();
 */

import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i<intervals.length;i++){
            int temp = intervals[i][0];
            if(temp>=pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}