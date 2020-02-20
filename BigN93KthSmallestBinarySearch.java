//Time complexity is O(log(m*n))
//Space complexity is O(1)
//This solution is submitted on Leetcode

public class BigN93KthSmallestBinarySearch {
	class Solution {
		public int kthSmallest(int[][] matrix, int k) {
			// edge case
			if (matrix == null || matrix.length == 0)
				return -1;
			int row = matrix.length;
			int column = matrix[0].length;
			int low = matrix[0][0];
			int high = matrix[row - 1][column - 1];
			while (low < high) {
				int mid = low + (high - low) / 2;
				int count = helper(matrix, mid);
				if (count < k)
					low = mid + 1;
				else
					high = mid;
			}
			return low;
		}

		private int helper(int[][] matrix, int k) {
			int length = matrix.length;
			int count = 0;
			for (int i = 0; i < length; i++) {
				int j = length - 1;
				while (j >= 0 && matrix[i][j] > k)
					j--;
				count += j + 1;
			}
			return count;
		}
	}
}
