// Time Complexity :nlogn
// Space Complexity :logn
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals== null || intervals.length==0) return 0;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            int peekval = q.peek();
            if(intervals[i][0]>=peekval){
                q.remove();
                q.add(intervals[i][1]);
            }
            else{
                q.add(intervals[i][1]);
            }
        }
        return q.size();
    }
}