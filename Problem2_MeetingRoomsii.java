// Time Complexity : o(NlogN)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals==null || intervals.length==0)
            return 0;
        
        int minCount=1;
         Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        PriorityQueue<Integer> pq=new PriorityQueue();
        pq.add(intervals[0][1]);
        
       
             
                    for(int i=1;i<intervals.length;i++)
                    {
                
                            if(pq.peek() <= intervals[i][0])
                            {
                                pq.poll();
                            }
                            else
                            {
                                minCount++;
                            }
                            pq.add(intervals[i][1]);
                        }
                    return minCount;
                    
}
    }
                    