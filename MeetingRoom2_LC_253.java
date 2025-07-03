/*
Min heap Approach -
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(NlogN)
Space Complexity - O(N)  no of elements in heap
*/
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2_LC_253 {
    public int minMeetingRooms(int[][] intervals) {
        //Sort by start index
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        //Iteration of intervals
        for(int i = 0 ; i <intervals.length; i++) { //5 10
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0]){
                pq.poll();
                pq.add(intervals[i][1]);
            } else{
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}