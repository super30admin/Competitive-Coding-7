//Time Complexity: O(m * n * log(max - min))
//Space Complexity: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, m, n, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int getCount(int[][] matrix, int m, int n, int mid) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= mid) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
