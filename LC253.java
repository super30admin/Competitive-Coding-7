//Time Complexity : O(nLogn)
//Space Complexity : O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        pq.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++)
        {
            int curr[] = intervals[i];
            int prev[] = pq.poll();
            
            if(curr[0] < prev[1])
            {
                pq.add(curr);
                pq.add(prev);
            }
            else
            {
                prev[1] = curr[1];
                pq.add(prev);
            }
        }
        
        return pq.size();
    }
}