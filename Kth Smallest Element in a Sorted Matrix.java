// Time Complexity :O(logn^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0)
      return -1;

    int rows = matrix.length, cols = matrix[0].length;
    int low = matrix[0][0], high = matrix[rows - 1][cols - 1];

    while (low < high) {
      int mid = low + (high - low) / 2;
      int count = count(matrix, mid, rows, cols);

      if (count < k)
        low = mid + 1;
      else
        high = mid;
    }
    return low;

  }

  private int count(int[][] matrix, int mid, int rows, int cols) { // max - O(n^2)/2
    int c = 0;
    int j = cols - 1;
    for (int i = 0; i < rows; i++) {
      while (j >= 0 && matrix[i][j] > mid)
        j--;
      c += j + 1;
    }
    return c;
  }
}