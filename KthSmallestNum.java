
// TimeComplexity: O(n log(max - min)) max/min are the largest/smallest elements.
// SpaceComplexity: O(1)

public class KthSmallestNum {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int col = n - 1;

            for (int row = 0; row < n; row++) {
                while (col >= 0 && matrix[row][col] > mid) {
                    col--;
                }
                count += (col + 1);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}









