// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            int peekVal = pq.peek();
            if(intervals[i][0] >= peekVal) {
                pq.remove();
                pq.add(intervals[i][1]);
            }
            else 
            {
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}