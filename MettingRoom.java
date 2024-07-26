import java.util.Arrays;
import java.util.PriorityQueue;

public class MettingRoom {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {

            if (pq.size() > 0 && pq.peek() <= interval[0]) {

                pq.poll();

            }

            pq.add(interval[1]);

        }

        return pq.size();

    }

    public static void main(String[] args) {
        MettingRoom m = new MettingRoom();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int ans = m.minMeetingRooms(intervals);
        System.out.println(ans);

    }

}
