/*
Time Complexity : O(logN)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 */
class Solution 
{
    public int minMeetingRooms(int[][] intervals) 
    {
    
        // sorts the intervals by their start time
        
        Arrays.sort( intervals, (arr1, arr2) -> arr1[0]- arr2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int interval[]: intervals)
        {
            int startTime = interval[0];
            int endTime = interval[1];
            
            if( !pq.isEmpty() )
            {
                int currentLowestEndTime = pq.peek();
                pq.add(endTime);
                if( startTime >= currentLowestEndTime)
                {
                    pq.poll();
                }
            
            }
            else
            {
                
                pq.add(endTime);
            }
        
        }
        
        return pq.size();
    }
}