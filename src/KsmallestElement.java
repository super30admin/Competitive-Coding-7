//Time Complexity : O(N+M * Log(M- N))
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * iterate over the matrix to find the number of elements less than the mid.
 * When count == k, then return min value which is obtained when binary search
 * is applied.
 *
 */
class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int min = matrix[0][0], max = matrix[n - 1][n - 1];
		int count = 0;
		while (min < max) {
			int mid = min + (max - min) / 2;
			count = binarySearch(matrix, mid);
			if (count < k) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

	public int binarySearch(int[][] matrix, int target) {
		int i = matrix.length - 1, j = 0;
		int count = 0;
		while (i >= 0 && j < matrix.length) {
			if (matrix[i][j] > target) {
				i--;
			} else {
				count += i + 1;
				j++;
			}
		}
		return count;
	}
}

// 1  5  9
//10 11 13
//12 13 15