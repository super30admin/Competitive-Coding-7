// The time complexity of this implementation is O(NLogN)
import java.util.*;

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Use a priority queue to keep track of the end times of the meetings
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add the first end time to the priority queue
        pq.offer(intervals[0][1]);

        // Iterate through the intervals and check if a new room is needed
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                // The start time of the new meeting is after the end time of a meeting that's currently taking place,
                // so we can reuse the same room
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }

        // The size of the priority queue is the minimum number of conference rooms required
        return pq.size();
    }
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int minRooms = solution.minMeetingRooms(intervals);
        System.out.println("Minimum number of conference rooms required: " + minRooms);
    }

}
