// Time complexity = O(n log n), where n = no. of rooms
// Space complexity = O(n), for the priority queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
import java.util.*;
public class Solution {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the input based on the start time
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        // Use a priority queue to keep track of the end times that finish first
        // We remove from the pq if the meeting ended before the start of a new meeting
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();  //vacate the room
            }

            pq.add(interval[1]);
        }

        return pq.size();
    }

    public static void main(String []args){
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}