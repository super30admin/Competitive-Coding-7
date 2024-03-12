// Time: O(n^2)
// Space: O(k)

// Approach: Maintain max heap with size k; Iterate the full heap
// and keep popping the top element of heap when size is more than k
// The last element at top will be kth smallest

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        return heap.poll();
    }
}
