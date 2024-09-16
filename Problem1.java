// Time Complexity : O(nlogk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes, 15ms
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Store the elements in a maxHeap and only keep k elements in the the heap, and return the top element

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        
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