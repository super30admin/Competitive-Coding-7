package S30.CompetitiveCoding_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Time Complexity : O(NlogN), N is number of intervals, worse case - if all intervals are overlapping
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class MeetingRooms_2 {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0 || intervals == null) return 0;

        Arrays.sort(intervals, new Comparator<int[]>(){

            @Override
            public int compare(int[] interval1, int[] interval2){
                return interval1[0] - interval2[0];
            }
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>(){

            @Override
            public int compare(int[] interval1, int[] interval2){

                return interval1[1] - interval2[1];
            }

        });

        minHeap.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){

            int start = intervals[i][0];
            int end = intervals[i][1];

            int[] lastEarliestMeeting = minHeap.poll();
            if(start >= lastEarliestMeeting[1]){
                lastEarliestMeeting[1] = end;
            }else{
                minHeap.offer(intervals[i]);
            }
            minHeap.offer(lastEarliestMeeting);
        }

        return minHeap.size();

    }
}
