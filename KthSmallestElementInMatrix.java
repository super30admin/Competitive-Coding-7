class KthSmallestElementInMatrix {
    // Using Binary Search
    public int kthSmallest(int[][] matrix, int k) {
        int kthSmallestElementCount = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            kthSmallestElementCount = getCount(matrix, mid);
            if (kthSmallestElementCount < k) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        return low;
    }

    private int getCount(int[][] matrix, int num) {
        int count = 0;
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] <= num) {
                count += column + 1;
                row++;
            } else {
                column--;
            }
        }

        return count;

    }
}