/// Time Complexity :O (n * log(n)) where n is the length of the intervala array as we need to first sort it
// Space Complexity :O(k) where k is size of the result list
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));// n * log (n)

        int maxConcurrentMeetings = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]- b[1]); //order by end Time
        for(int[] meeting : intervals){
            while(!pq.isEmpty() && pq.peek()[1] <= meeting[0]){
                pq.poll();
            }
            pq.add(meeting);
            maxConcurrentMeetings = Math.max(maxConcurrentMeetings, pq.size());
        }
        return maxConcurrentMeetings;
    }
}
