import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1 {
    // TC : O (logn)
    // SC : O (n)
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
