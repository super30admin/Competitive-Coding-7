// Time complexity is O(m*n)
// Space complexity is O(m+n)
// This solution is submitted on Leetcode

import java.util.PriorityQueue;

public class BigN93KSmallestElementInMatrix {
	class Solution {
		public int kthSmallest(int[][] matrix, int k) {
			// edge case
			if (matrix == null || matrix.length == 0)
				return -1;
			int row = matrix.length;
			int column = matrix[0].length;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					pq.add(matrix[i][j]);
				}
			}
			int result = 0;
			for (int i = 0; i < k; i++) {
				result = pq.poll();
			}
			return result;
		}
	}
}