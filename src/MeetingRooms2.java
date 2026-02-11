import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem - Given an array of meeting time intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.
Approach - First, we sort all meetings by start time.
We use a min-heap to track meetings by end time and remove any that have ended.
The heap size at the end tells how many rooms we needed at max.
Time Complexity - O(nlogn)
Space Complexity - O(n)
 */
public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] );
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }

}
