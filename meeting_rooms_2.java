import java.util.Arrays;
import java.util.PriorityQueue;

public // Time Complexity : O(n log n) because we sort meetings and use a Min Heap for room allocation
// Space Complexity : O(n) for the Min Heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We sort meetings by start time and use a Min Heap to track the earliest ending meeting room.
// If the current meeting starts after or at the earliest end time, we reuse that room by removing it from the heap.
// The heap size at the end represents the minimum number of meeting rooms required.

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        // sort by start time
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        // min heap stores end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval: intervals) {

            // reuse room if earliest meeting ended
            if(!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(interval[1]);
        }

        return pq.size();
    }
} {
    
}
