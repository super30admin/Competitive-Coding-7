// Problem 378. Kth Smallest Element in a Sorted Matrix
// Time Complexity : O(klogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        int count = 0;
        int result = 0;
        while (count < k) {
            int[] current = minHeap.poll();
            result = current[0];
            int row = current[1], col = current[2];
            // If there's a next column in the same row, add it to the heap
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
            count++;
        }
        return result;
    }
}
