// Time Complexity :Nlog(N), N = number of intervals, N for iteration and logN for heapify
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MeetingRoomsII {
    class Solution { // [[0,30],[5,10],[15,20]]
        public int minMeetingRooms(int[][] intervals) {
            if(intervals == null || intervals.length == 0) return 0;
            if(intervals.length == 1) return 1;

            Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

            Queue<Integer> heap = new PriorityQueue<>();
            for(int[] interval : intervals) {
                if(heap.isEmpty()) {
                    heap.add(interval[1]);
                } else {
                    int currIntervalEndTime = heap.peek();
                    if(interval[0] < currIntervalEndTime) {
                        heap.add(interval[1]);
                    } else {
                        heap.poll();
                        heap.add(interval[1]);
                    }
                }
            }
            return heap.size();
        }
    }
}
