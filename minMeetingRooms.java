// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    public static int minMeetingRooms(int[][] intervals) {
        // sort array by there starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // min priorityQueue by there ending time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // intialilly count is 1 as 1 room is always required
        int count = 1;
        // add first interval into queue
        pq.add(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            // if minimum ending time is less than the incoming starting time than we poll
            // from the pq else count++ as we require one more room
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            } else {
                count++;
            }
            // add interval into the pq
            pq.add(intervals[i]);
        }
        // return count;
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                { 0, 30 },
                { 5, 10 },
                { 15, 20 }
        };
        System.out.println(minMeetingRooms(intervals));
    }
}