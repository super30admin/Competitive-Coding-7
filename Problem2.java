// https://leetcode.com/problems/meeting-rooms-ii/


// Time Complexity : O(nlog(n))
// Space Complexity :O(rooms used)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//sort all the meeting according to the start time.
//store end time of first meeting in a minheap, for next meeting if heap.peek <= start time
//of next meeting, we remove that and add this meeting's end time to the heap, else
//we add the end time without removing previous, keep doing this for n meeting.
//size of heap=number of rooms used.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        pq.add(intervals[0][1]);
        for(int i=1; i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(pq.peek()>start){
                pq.add(end);
            }
            else{
                pq.poll();
                pq.add(end);
            }
        }
        return pq.size();
    }
}