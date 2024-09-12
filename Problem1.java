// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// Time complexity : nlog(max-min)
// Space complexity : O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = numOfElementsToLeft(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int numOfElementsToLeft(int matrix[][], int target) {
        // Find the number of elements less than or equal to target
        int n = matrix.length;
        int r = 0;
        int c = n - 1;
        int count = 0;
        while (r < n && c >= 0) {
            if (matrix[r][c] <= target) {
                r++;
                count += (c + 1);
            } else {
                c--;
            }
        }
        return count;
    }
}