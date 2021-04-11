import java.util.Arrays;
import java.util.PriorityQueue;
//tc : O(nlogn)
//sc : O(n)
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 ) return 0;

        //sort acc to start time
        Arrays.sort(intervals,
                (a, b) -> {
                    return a[0] - b[0];
                }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int end = pq.peek();
            if (intervals[i][0] >= end) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

}
