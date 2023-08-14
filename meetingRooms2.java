// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Sort the intervals based on start time.
 * 2. Initialize a priority queue to store the intervals sorted based on earliest end time.
 * 3. Iterate through the intervals and check if the start time of current interval is greater 
 *    than or equal to the end time of the interval at the top of the priority queue.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> numRooms = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        
        for(int[] interval : intervals){
            int[] prev = numRooms.peek();
            if(prev != null && interval[0] >= prev[1]){
                numRooms.poll();
            }
            
            numRooms.offer(interval);
        }

        return numRooms.size();
    }
}