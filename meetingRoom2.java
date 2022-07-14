// Time Complexity : O(n) 
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int[] num: intervals){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(p.isEmpty()){
                p.add(arr[1]);
                continue;
            }
            if(p.peek() <= arr[0]){
                p.remove();
            }
            p.add(arr[1]);
        }
        return p.size();
    }
}