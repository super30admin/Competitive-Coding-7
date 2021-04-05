
// Time Complexity : O(nlogn) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    public int minMeetingRooms(int[][] intervals) {
      
      if(intervals == null || intervals.length==0)
      {
        return 0;
      }
      //usign a min heap
      PriorityQueue<Integer> heap = new PriorityQueue<>();
      //sort the array in natural oreder based on the first value(starting time) of every sub array
      Arrays.sort(intervals,(a,b)->a[0]-b[0]);
      //add the first element to the heap
      heap.add(intervals[0][1]);
      for(int i=1;i<intervals.length;i++)
      {
        //get the start and end time for each meeting
        int start = intervals[i][0];
        int end = intervals[i][1];
        //this mean the meeting start before the end time of the previous meeting and the start time would be after the start time of
        //the previous meeting as we already sorted it before
        if( start<heap.peek())
        {
          heap.add(end);
        }
        //the meeting starts after the end of any other meeting in the heap so we can remove that window and insert the new one in place of that
        //meaning the same room can be used
        else
        {
          heap.poll();
          heap.add(end);
        }
      }
      //the size is actually the number of rooms required as we removed any meeting that ended before any other started
       return heap.size();
    }
}