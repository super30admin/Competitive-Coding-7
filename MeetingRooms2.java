//Time Complexity NLog(N)
//Space Complexity O(M)  Priority Queue
//LeetCode tested

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals,(a,b) ->  a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval:intervals) {
            if(pq.size() > 0 && pq.peek() <= interval[0])
                pq.poll();
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
