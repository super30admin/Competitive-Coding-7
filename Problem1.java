import java.util.Arrays;
import java.util.PriorityQueue;

// Time Complexity : O(n) 
// Space Complexity : O(n) where n is the pxq , p entry of start time and q entry for end time.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //edge case
        if(intervals == null) return 0;
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x,y)->x[1]-y[1]);
        
        for(int i = 0 ; i < intervals.length; i++)
        {
            if(!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()[1])
            {
                minHeap.poll();
            }
            minHeap.add(intervals[i]);
        }
        return minHeap.size();
        
    }
}