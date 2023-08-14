// Time Complexity : O(n log n) + O(n log n)  -> O(n log n)
// O(n log n) for sorting the array. -> n is the number of elements in intervals array
// O(n log n) for finding the meeting rooms. -> n is the number of intervals in heap.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals,(a, b)->a[0]-b[0]);

        for(int[] interval : intervals){

            if(!pq.isEmpty() && interval[0] >= pq.peek())
            {
                {
                    pq.poll();
                }
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }



}
