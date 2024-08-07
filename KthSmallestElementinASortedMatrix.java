// Time Complexity: O(m log(max - min)) 
// Space Complexity: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);
            if (count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    private int getCount(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && matrix[i][j] > mid)
                j--;
            count += j + 1;
        }
        return count;
    }
}