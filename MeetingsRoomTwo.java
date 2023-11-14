// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingsRoomTwo {
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
