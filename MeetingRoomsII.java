package competitiveCoding7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	//Time Complexity : O(n log n), where n is the size of intervals array
	//Space Complexity : O(n), for elements in MinHeap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        if(intervals.length == 1)
            return 1;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(intervals[0]);
        
        for(int i=1; i<intervals.length; i++) {
            int[] curr = minHeap.poll();
            int[] next = intervals[i];
            if(curr[1] <= next[0]) {
                curr[0] = Math.min(curr[0], next[0]);
                curr[1] = next[1];
                minHeap.add(curr);
            } else {
                minHeap.add(curr);
                minHeap.add(next);
            }
        }
        
        return minHeap.size();
    }
}
