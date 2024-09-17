// Time Complexity : Nlog(max-min)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high) {

            int mid = low + (high - low)/2;
            int count = helperCount(matrix, mid, n);

            if(count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;       
    }
    
    public int helperCount(int[][] matrix, int mid, int n) {
        int row = 0;
        int col = n-1;
        int count = 0; 
        
        while(row < n && col >= 0) {
            if(matrix[row][col] <= mid) {
                count += col+1;
                row++;
            }
            else {
                col--;
            }
        }
        return count; 
    }
}