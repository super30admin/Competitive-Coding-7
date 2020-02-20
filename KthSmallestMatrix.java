
// Time Complexity : O(N^2 log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
		int left = matrix[0][0], right = matrix[matrix.length - 1][matrix.length - 1];

		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = getCount(matrix, mid);
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;

	}

	public int getCount(int matrix[][], int mid) {
		int count = 0, size = matrix.length - 1;

		for (int i = 0; i < size; i++) {
			int j = size;
			while (j >= 0 && matrix[i][j] > mid) {
				j--;
			}
			count += j - 1;
		}
		return count;
	}
}