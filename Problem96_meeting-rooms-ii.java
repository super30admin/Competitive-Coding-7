// TC: O(n log n), where n = length of the array
// SC: O(n)
import java.util.*;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        minHeap.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= minHeap.peek())
                minHeap.poll();
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}