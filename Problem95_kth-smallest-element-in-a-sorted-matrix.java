// TC: O(nlog(hi - lo)) -> hi - lo is the range of search
// SC: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int count = helper(mid, matrix);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } 
        return lo;
    }
    private int helper(int mid, int[][] matrix) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}