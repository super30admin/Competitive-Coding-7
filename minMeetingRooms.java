// Time Complexity : O(nlogn) n is number of intervals
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            int topVal = pq.peek();
            if(topVal <= intervals[i][0]){
                pq.remove();
                pq.add(intervals[i][1]);
            }
            else{
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}