// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int interval[]:intervals){
            if(!pq.isEmpty() && interval[0]>=pq.peek()){
                pq.poll();       
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}