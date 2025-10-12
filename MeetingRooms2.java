import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//TC: O(nlogn), SC: O(n)
public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval: intervals) {
            if (!pq.isEmpty()) {
                if (interval[0] >= pq.peek()) pq.poll();
            }

            pq.offer(interval[1]);
        }

        return pq.size();
    }
}
