import java.util.Arrays;
import java.util.PriorityQueue;

/*
Meeting Rooms
approach: sort the given array first based on start times, use a min heap to keep min end time on top of queue,
for each meeting compare, start time with top, if startTime>=top then pop else increase count;
time: O(n log n)
space: O(n)
 */
public class Problem2 {
    private int meetingRooms(int[][] meetings) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]));
        int count= 0;
        for (int i = 0; i < meetings.length; i++) {
            pq.add(meetings[i][1]);
            if (meetings[i][0] >= pq.peek()) {
                pq.poll();
            } else count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.meetingRooms(new int[][]{{0,30},{5,10},{15,20}});
    }


}
