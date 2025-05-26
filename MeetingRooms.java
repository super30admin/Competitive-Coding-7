
// TimeComplexity: O(n * log(n))
// SpaceComplexity: O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> 
        {
            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return -1;
            else return 0;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) 
        {
            int[] interval = intervals[i];
            if (pq.size() > 0 && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();

    }
}
