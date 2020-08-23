// Time Complexity : O(log(n)) --> where n is the length of input 2-D Array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (378) : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // edge case
        if (matrix == null || matrix.length == 0) return -1;
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int counter = count(matrix, mid);
            if (counter < k) low = mid + 1;
            else high = mid; 
        }
        return low;
    }
    
    private int count(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > mid) j--;
            count += j + 1;
        }
        return count;
    } 
}