// Time Complexity : O(logn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLess(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private int countLess(int[][] matrix, int mid) {
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            }else{
                row--;
            }
        }

        return count;
    }
}