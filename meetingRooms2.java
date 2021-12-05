// Time Complexity : O(nlogn)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : don't have leetcode premium
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int conference(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length);
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}