/**
Time Complexity : O(NlogN) + O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int minMeetingRooms(int[][] intervals) 
    {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int interval[]: intervals)
        {
            if(!queue.isEmpty())
            {
                int[] peekedElem = queue.peek(); // earliest ending interval
                
                if(peekedElem[1] <= interval[0])
                {
                    queue.poll();
                }
                queue.add(interval);
            }
            else
            {
                queue.add(interval);
            }
        }
        
        return queue.size();
            
    }
}