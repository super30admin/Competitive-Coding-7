//ip : [[0,10],[4,7],[11,12],[31,35], [12,16]]
//logic: first sort the array based on the start time!
//priority q -Min Heap, enter the value based on peeking and see if peeked value is smalller than than the value in the array
//than poll the current value, and add the current. else juts add the current interval
//at last the size of the priority Q is the number of meeting rooms required. 
//tc : O(n) sorting + n log n for heap

import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // base case
        if (intervals.length == 0 || intervals == null)
            return -1;

        // sort the array based on the start time - intervals -> a[0]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // priority que for the end time , to heck if it's more than or equal to than
        // previous's start time
        // and for previous value, we are peeking at Minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) // start time comparision with peeking the end time
            {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}