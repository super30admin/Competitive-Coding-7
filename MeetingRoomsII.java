//Time Complexity : O(NLogN), N -> Number of meetings
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.offer(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {

            if(pq.peek() <= intervals[i][0])
                pq.poll();

            pq.add(intervals[i][1]);
        }

        return pq.size();

    }
}