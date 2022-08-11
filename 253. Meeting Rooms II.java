// Time Complexity: O(n log m)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}