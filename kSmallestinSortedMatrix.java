// Time Complexity : O(n + klogk)
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}