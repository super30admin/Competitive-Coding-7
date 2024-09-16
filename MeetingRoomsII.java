// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //sort according to start times
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //put end time of first interval
        pq.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {

            int minEnd = pq.peek();

            //if top of pq finishes before (less than or equal to) incoming interval end time, remove the top and give it's room to incoming meeting
            if(minEnd <= intervals[i][0])
                pq.poll();

            //if can't accomodate (greater than) incoming interval end time, add to queue
            pq.add(intervals[i][1]);

        }

        //we reach end of array and the meeting rooms in pq is the answer
        return pq.size();

    }
}
