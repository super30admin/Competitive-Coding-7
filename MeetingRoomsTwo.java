import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && (interval[0] >= pq.peek())) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomsTwo solution = new MeetingRoomsTwo();

        // Test Case 1
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int result1 = solution.minMeetingRooms(intervals1);
        System.out.println("Minimum number of meeting rooms required: " + result1);

        // Test Case 2
        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        int result2 = solution.minMeetingRooms(intervals2);
        System.out.println("Minimum number of meeting rooms required: " + result2);

        // Test Case 3
        int[][] intervals3 = { { 1, 5 }, { 2, 3 }, { 3, 4 } };
        int result3 = solution.minMeetingRooms(intervals3);
        System.out.println("Minimum number of meeting rooms required: " + result3);
    }
}