// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int getCount(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > mid)
                j--;
            count += j + 1;
        }
        return count;
    }
}