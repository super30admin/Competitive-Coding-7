// Time Complexity : O(nlog n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
  public static void main(String[] args) {
    int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(Main.meeting(intervals));
  }

  private static int meeting(int[][] intervals) {

        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            int temp = pq.peek();

            if(temp < intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}