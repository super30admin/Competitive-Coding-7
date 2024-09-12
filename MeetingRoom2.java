// Time Complexity : O(n log (n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        for(int i = 0; i < intervals.length; i++){
            if(!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i]);
        }

        return pq.size();
    }
}
