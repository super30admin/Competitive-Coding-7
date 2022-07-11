// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Time Complexity: O(n log(n))
// Space Complexity: O(n) 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.PriorityQueue;

class kthSmallest {
    public static int getkthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(matrix[i][j]);

                if (maxHeap.size() > k) {
                    maxHeap.remove();
                }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k = 8;
        System.out.println("8th Smallest: " + getkthSmallest(matrix, k));
    }
}