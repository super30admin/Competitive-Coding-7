/**
* Time Complexity:
* O(Nlogm) where m is the number of possible meeting rooms and N is the number of elements given
*
*/

/*
* The space complexity is O(N)
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        //using max heap
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the input based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Use a priority queue to keep track of the end times that finish first
        // We remove from the pq if the meeting ended before the start of a new meeting
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] >= pq.peek()[1]) {
                pq.poll();  //vacate the room
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
