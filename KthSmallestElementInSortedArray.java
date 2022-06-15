// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class KthSmallestElementInSortedArray {
    public int kthSmallest(int[][] matrix, int k) {
        // null case
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }
}
