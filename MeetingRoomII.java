// Time Complexity : O(nlogn)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sort Intervals: First, sort the meeting intervals by their start time.
// Use a Priority Queue: Use a priority queue (min-heap) to keep track of the end times of ongoing meetings.
// For each interval:
// If the meeting can start after the earliest ending meeting, remove the earliest ending meeting from the queue.
// Add the end time of the current meeting to the queue.
// Result: The size of the priority queue at the end represents the minimum number of meeting rooms needed,
// as it holds the end times of all overlapping meetings.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval:intervals){
            if(pq.size() != 0 && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}