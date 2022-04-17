// Time Complexity : O(nlog(n)) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Priority Queue
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //Empty array case
        if(intervals == null || intervals.length == 0) return 0;
        
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>( intervals.length,
                                                                  new Comparator<Integer>() {
                                                                      public int compare(Integer x, Integer y) {
                                                                          return x - y;
                                                                      }
                                                                  });
        //Sorting the elements by start time
         Arrays.sort( intervals, new Comparator<int[]>() {
             public int compare(final int[] x, final int[] y) {
                 return x[0] - y[0];
             }
         });
        
        //Intially allocating room for first meeting
        rooms.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {

          // if the meeting is starting after the end time of the other meeting
          if (intervals[i][0] >= rooms.peek()) {
            rooms.remove();
          }

          //Adding the meeting to the heap
          rooms.add(intervals[i][1]);
        }

        // Size of the heap equals minimum rooms
        return rooms.size();
        
    }
}
