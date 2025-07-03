/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Approach - Binary Search
Time complexity - O(NlogR)
Space complexity - O(1)
 */
public class KthSmallestElementSortedMatrix_LC_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0],  end = matrix[n-1][n-1];
        while( start < end) {
            int mid = start + (end- start) / 2;
            int count = getCount(matrix, mid);
            if(count < k) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int getCount(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length-1;
        for(int i = 0; i < matrix.length; i++) {
            while( j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            count+= j+1;
        }
        return count;
    }
}



