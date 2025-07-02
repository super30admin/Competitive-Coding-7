//Time Complexity: O(n * log(max - min)) where n = matrix.length, and min, max are the smallest and largest values in the matrix.
//Space Complexity: O(1)
//Did this code successfully run on Leetcode: YES
//Any problem you faced while coding this: YES

class KthSmallestInSortedMatrix_LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lowest = matrix[0][0], highest = matrix[n-1][n-1];

        while (lowest < highest) {
            int mid = lowest  + ((highest - lowest) / 2);
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                lowest = mid + 1;
            } else {
                highest = mid;
            }
        }
        return lowest;
    }

    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n - 1, col = 0, count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}