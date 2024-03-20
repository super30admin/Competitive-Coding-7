// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int max = 0;
        for(int[] inter : intervals) {
                                    //30     5
            while(!pq.isEmpty() && pq.peek() <= inter[0]) {
                max = Math.max(max, pq.size());
                pq.poll();
            }
            pq.add(inter[1]);            
        }
        return max;
    }
}