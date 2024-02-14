import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    // TC: O(NlogN) where N is length of intervals
    // SC: O(N) where N is length of intervals
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(end);
        }
        return minHeap.size();
    }
}
