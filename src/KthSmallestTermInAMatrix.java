/*
Problem - Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Approach - We binary search between the smallest and largest element in the matrix.
For each mid, we count how many numbers are less than or equal to it.
Because the matrix is sorted row-wise and column-wise, we can count how many elements are <= mid in O(n) time using a
staircase walk from the bottom-left without any extra data structures.
Time Complexity - O(n*log(max-min))
Space Complexity - O(1)
 */
public class KthSmallestTermInAMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix,mid);
            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
    public int getCount(int[][] matrix, int mid) {
        int n = matrix.length;
        int r = n - 1, c = 0;  // start bottom-left
        int count = 0;

        while (r >= 0 && c < n) {
            if (matrix[r][c] <= mid) {
                // everything above (0..r) in this column is <= mid
                count += (r + 1);
                c++; // move right
            } else {
                r--; // move up
            }
        }
        return count;
    }
}
