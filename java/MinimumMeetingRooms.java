Meeting Rooms II

        Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



        Example 1:

        Input: intervals = [[0,30],[5,10],[15,20]]
        Output: 2
        Example 2:

        Input: intervals = [[7,10],[2,4]]
        Output: 1


        Constraints:

        1 <= intervals.length <= 104
        0 <= starti < endi <= 106

// Time Complexity : O(N log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length==0)
            return 0;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=queue.peek()){
                queue.poll();
            }
            queue.add(intervals[i][1]);

        }
        return  queue.size();
    }
}
