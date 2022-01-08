// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Sort the given array based on start value, Set the endvalue of each to the min stack (priority queue), check the peek() of the queue is less or equal to the end of each value, if yes then remove the peek( using .remove()) and add all the end points to the pqueue. at the end return q.size()
// Your code here along with comments explaining your approach
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // null
        if(intervals == null || intervals.length == 0) return 0;
        // sort the array
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        // pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i ++){
            if(pq.peek() <= intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}