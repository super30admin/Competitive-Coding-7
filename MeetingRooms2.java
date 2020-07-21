// Time Complexity : O(nlog n) where n is the number of activities taking place (Sorting by start time + Adding to the Min heap)
// Space Complexity : O(n) where n is the number of activities in the min heap queue at the worst case
import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));

        for(int[] i : intervals)
        {
            if(!pq.isEmpty() && i[0] >= pq.peek()[1])
            {
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();

    }
}
