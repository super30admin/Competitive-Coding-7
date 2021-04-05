//Time Complexity : O(nlogn)
//Space Complexity : O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
      
      if(intervals == null || intervals.length==0)
      {
        return 0;
      }
      
      PriorityQueue<Integer> heap = new PriorityQueue<>();
      Arrays.sort(intervals,(a,b)->a[0]-b[0]);
      heap.add(intervals[0][1]);
      for(int i=1;i<intervals.length;i++)
      {
        int start = intervals[i][0];
        int end = intervals[i][1];
        if( start<heap.peek())
        {
          heap.add(end);
        }
        else
        {
          heap.poll();
          heap.add(end);
        }
      }
       return heap.size();
    }
}