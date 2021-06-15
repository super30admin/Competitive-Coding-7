// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity :O(nlogn) where o(n) for traversing through the intervals array and O(nlogn) for sort
//Space Complexity: O(n) in the worst case scenario since we are using any extra space

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
        
        pq.add(intervals[0][1]);
            
        for(int i = 1; i < intervals.length; i++){
            
            if(intervals[i][0] < pq.peek()){
                pq.add(intervals[i][1]);
            }else{
                pq.add(intervals[i][1]);
                pq.poll();                
            }
        }        
        return pq.size();       
    }
}