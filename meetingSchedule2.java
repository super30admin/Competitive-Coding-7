//Time complexity O(nlog(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0 || intervals == null || intervals[0] == null){
            
           return - 1; 
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        Arrays.sort(intervals, (a,b) -> (a[0]) - b[0]);
        pq.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i ++){
            
            int temp = pq.peek();
            if(intervals[i][0] >= temp ){
                
                pq.poll();
                pq.add(intervals[i][1]);
                //result ++;
            }
            else {
                
                pq.add(intervals[i][1]);
            }
        }
        
        result = pq.size();
        
        return result;
    }
}