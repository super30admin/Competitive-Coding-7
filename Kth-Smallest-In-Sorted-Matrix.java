// Time Complexity : O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> (b - a) // comparator for max heap
        );
        
        for(int[] nums : matrix) {
            for(int num : nums) {
                pq.add(num);
                
                if (pq.size() > k) {
                   pq.remove();
                }
            }
        }
        return pq.remove();
    }
}