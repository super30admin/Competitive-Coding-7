import java.util.*;

/**
 * Time complexity: O(NlogN) where N is length of intervals, 
 * Space complecity: O(N) size of heap
 * 
 * Approach:
 * 1. Sort the intervals as per the start times.
 * 2. Add the end time of meetings int heap (minHeap) which has the least end time at the top of the heap.
 * 3. Compare each interval's end time with the top of the heap and if it's greater the remove top element from
 * the heap.
 * 4. At the end, size of the heap is number of meeting rooms required.
 */

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        minHeap.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}