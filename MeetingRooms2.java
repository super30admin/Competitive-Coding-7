package CompetitiveCoding7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    /* Created by palak on 8/8/2021 */

    /**
     Time Complexity: O(nlogk)
     Space Complexity: O(n)
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        int count = 1;
        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] < pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}