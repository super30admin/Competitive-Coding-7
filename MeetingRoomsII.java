// Time Complexity : O(nlogn) where n = number of elements in intervals matrix
// Space Complexity : O(k) where k = maximum size of heap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//253. Meeting Rooms II (Medium) - https://leetcode.com/problems/meeting-rooms-ii/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        
        return pq.size();
    }
}