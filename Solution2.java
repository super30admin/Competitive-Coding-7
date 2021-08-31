//Time complexity: O(NlogN), where N is the size of the intervals.
//Space complexity: O(N)

import java.util.*;

class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0; 
        
        //sort the intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
    
        for(int i=0; i<intervals.length; i++) {
            if(!pq.isEmpty()) {  
                int[] prevMeeting = pq.peek(); 
                if(prevMeeting[1] <= intervals[i][0]) {
                    pq.poll();
                }
            }
            pq.offer(intervals[i]); 
            
        }
        return pq.size(); 
    }
}