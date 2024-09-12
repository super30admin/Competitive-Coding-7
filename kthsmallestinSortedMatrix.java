//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
/*
Time: O(M+N logD) where M=rows, N=cols, D=diff between highest and lowest element in matrix.
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class kthsmallestinSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessThanOrEqualToMid(matrix, mid);

            if (count < k)
                low = mid + 1;

            else
                high = mid;
        }

        return low;
    }

    // Same as Search a 2D Matrix II
    public int lessThanOrEqualToMid(int[][] matrix, int target) {
        int count = 0;
        int row = 0, col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] > target) {
                col--;
            }

            else {
                count = count + col + 1;
                row++;
            }

        }

        return count;
    }

}
