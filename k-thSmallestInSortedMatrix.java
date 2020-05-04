//time complexity:  O(K*logN)
//space complexity: O(N)

import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->
 b - a);
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (maxHeap.size() < k)
                {
                    maxHeap.add(matrix[i][j]);
                }
                else if (maxHeap.peek() > matrix[i][j])
                {
                    maxHeap.poll();
                    maxHeap.add(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }
}