// Meeting Rooms II

// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 1)
            return 1;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < n; i++){
            int endTime = pq.peek();
            if(intervals[i][0] < endTime){
                pq.add(intervals[i][1]);
            } else {
                pq.poll();
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}