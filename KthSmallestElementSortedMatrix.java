// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class KthSmallestElementSortedMatrix {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int left = matrix[0][0];
            int right = matrix[m-1][m-1];
            int count = 0;

            while( left <= right){
                int midVal = (right + left) / 2;
                count = countLessElements(midVal, matrix);
                if(count < k)
                    left = midVal + 1;
                else
                    right = midVal - 1;
            }
            return left;
        }

        private int countLessElements(int val, int[][] matrix){
            int cnt = 0;
            int n = matrix.length;

            for(int i = 0; i < n; i++){
                int j = n - 1;
                while(j >= 0 && matrix[i][j] > val){
                    j--;
                }
                cnt = cnt + j + 1;
            }
            return cnt;
        }
    }
}
