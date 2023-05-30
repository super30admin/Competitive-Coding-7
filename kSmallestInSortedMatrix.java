// Time Complexity : O(n^2)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a max heap with the size restricted to k, in order to find the k max
 * elements in the matrix. The size of the queue is restricted so that once the
 * matrix traversal is done, we have the k-th smallest element at the top of the
 * heap. (kth smallest is the kth popped element in the heap)
 */

import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) {
            return -1;
        }

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                pq.add(matrix[i][j]);
                // restrict space to k
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}