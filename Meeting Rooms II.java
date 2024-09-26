// Time Complexity : O(nlogn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution{
    public int minMeetingRooms(int[][] intervals){
        // sort according to the start times
        Arrays.sort(intervals, (a,b) -> a[0]- b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] interval : intervals){
            // check if priority queue isn't empty and top element(end time) is less than next's start time
            if(!pq.isEmpty() && pq.peek() < intervals[0]){
                // remove the top(end time) from the list and add next's end time to the heap
                pq.poll();
            }
            // add end time to the heap
            pq.add(intervals[1]);
        }

        // return the size of the heap
        return pq.size(;)
    }
}