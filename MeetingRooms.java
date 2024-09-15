    // Time Complexity : O(NlogN)  N: all activities
// Space Complexity : O(N) worst case if new meeting room required for all
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 
 class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length) return 0;
        
        Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          public int compare(final int[] a, final int[] b) {
            return a[0] - b[0];
          }
        });
        
        int result = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[i][1]);
        for(int i=1; i<intervals.length; i++){
          //  int x = pq.add(intervals[i][1])
            if(intervals[i][0] < pq.peek()){
                result++;
            }
            else{
                pq.remove();
            }
            
            pq.add(intervals[i][1]);
        }        
        return result;
    }
    
}