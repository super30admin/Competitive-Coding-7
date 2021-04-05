
// Time Complexity : O(n logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        queue.add(intervals[0]);
        for(int i=1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < queue.peek()[1]){
                queue.add(curr);
            }else{
                queue.poll();
                queue.add(curr);
            }
        }
        return queue.size();
    }
}
