package com.ds.rani.array;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
//Approach: take first element as a low, last as a hight and find the mid element for this.
//now check how many elements are there before mid, if it is k elements then return else adjust low or how.

//Time Complexity:o(log n) * something where n=rows*cols. bit confused in time complexity
//Space Complexity:o(1)
public class KthhSamllestElementInMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        //low an hi are numbers, not indices
        int low = matrix[0][0];
        int hi = matrix[n - 1][n - 1];

        while (low <= hi) {
            int mi = low + ((hi - low) / 2);
            int count = countSmallerThanMid( mi, matrix );
            if (count < k) {
                low = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return low;
    }

    private static int countSmallerThanMid(int midElement, int[][] matrix) {
        int rows = matrix.length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            int col = rows - 1;
            while (col >= 0 && matrix[row][col] > midElement)
                col--;
            count += col + 1;
        }

        return count;
    }
}
