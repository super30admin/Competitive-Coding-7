// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int minMeetingRooms(int[][] intervals) {
    // Edge case
    if(intervals == null || intervals.length == 0) return 0;
    // Srt the array based  on starting time
    Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // Add first ending time
    pq.add(intervals[0][1]);

    for(int i = 1; i<intervals.length; i++) {
      // If the next starting time is greater than or eaqual to the present ending time, remove the first entry as both can use the same room.
      if(intervals[i][0] >= pq.peek()) {
        pq.poll();
      }
      // Add new entry to the queue.
      pq.add(intervals[i][1]);
    }
    return pq.size();
  }
}