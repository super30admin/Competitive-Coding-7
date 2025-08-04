// Time Complexity : O(nlog(n) for sorting in ascending order)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I first sorted the intervals based on start time, then I added the ending time of the first interval to the pq, now, at every interval, if any of the previous meetings finished before (peek value is <=) the start of this interval, I can remove that meeting and add this one, else I need a new room. At the end I simply return the number of rooms, i.e., size of the heap

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i = 1; i<intervals.length; i++) { 
            if(pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}



