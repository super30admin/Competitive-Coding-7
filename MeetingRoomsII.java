package com.ds.rani.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
//Approach: Make start array and end array. sort both the arrays.
// if the start time< end time, it means new room will be needed so increment count. otherwise move to next end time
//Time Complexity:o(nlogn) where n is number of intervals
//Space Complexity:o(n)
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];

        }
        Arrays.sort( start );
        Arrays.sort( end );
        int room = 0;
        int endsItr = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endsItr])
                room++;
            else
                endsItr++;
        }
        return room;
    }
}
