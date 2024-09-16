// Kth Smallest Element in a Sorted Matrix

// Time Complexity : O(mnlog(mn))
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

// MinHeap solution
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                pq.add(matrix[j][i]);
                if(pq.size() > k)
                    pq.poll();
            }
        }
        return pq.peek();
    }
}