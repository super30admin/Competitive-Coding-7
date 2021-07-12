import java.util.Arrays;
import java.util.PriorityQueue;

public class RoomMeetingsII {

    /*
     * TC : O(N logN) where N is the number of intervals.
     * SC : O(1)
     * @param intervals
     * @return
     */

    /**
     * The approach here is simplistic. We sort the given intervals matrix based on the starting time
     * and start allocating meeting rooms to the meetings that occur initially.
     * When allocating a new room, we check whether a completely new room is needed or a previous one that was used has been freed.
     * <p>
     * To check whether a previous room has been freed, we just care that whether previous rooms have ending times that
     * is less than starting time of the new meeting. We dont care which room this might be.
     * Hence, we use a min heap here and compare the top of the heap (i.e, the room that will get freed the first )
     * to the current meeting's end time.
     * <p>
     * If the top is less that means, a previous occupied room will get freed. In this case, we dont have to take up a new room
     * We just pop the room to denote that it is now freed.
     * <p>
     * Else we would need a new room and we increase the count of the rooms needed.
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        pq.add(intervals[0][1]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                if (intervals[i + 1][0] < pq.peek()) {
                    count++;

                } else {
                    pq.poll();
                }


            } else {
                pq.poll();

            }
            pq.add(intervals[i + 1][1]);
        }
        return count;
    }
}
