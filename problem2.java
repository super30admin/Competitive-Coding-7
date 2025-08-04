// Time Complexity : O(n log(range of elements))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I used the fact that the array is sorted left and right and top to bottom - I pick the middle of high and low and count the number of elements which are less than it (in a binary search manner), if it is more than or equal to k, we need to push high back so it converges to lowest low for which this works (element has to be from the matrix), else we move low ahead.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        // O(range)
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        // O(2n) = O(n)
        int n = matrix.length;
        int row = n - 1, col = 0;
        int count = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1; 
                col++;
            } 
            else row--;
        }
        return count;
    }
}