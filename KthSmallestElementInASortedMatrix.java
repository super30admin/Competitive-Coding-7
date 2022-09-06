// Time Complexity : O(logn) where n = number of elements in matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//378. Kth Smallest Element in a Sorted Matrix (Medium) - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
    	// Time Complexity : O(n*n) where n = number of rows/columns
    	// Space Complexity : O(n*n) where n = number of rows/columns
//        if(matrix == null || matrix.length == 0) return -1;
//        int n = matrix.length;
//        int [] result = new int[n*n];
//        int index = 0;
//        
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                result[index++] = matrix[i][j];
//            }
//        }
//        
//        Arrays.sort(result);
//        return result[k-1];
    	
    	int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        
        while (start <= end) { // O(logn) where n = number of elements in matrix
            int mid = start + (end-start)/2;
            int count = countElementsLessThan(matrix, mid);
            
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
    
    private int countElementsLessThan(int[][] matrix, int num) {
        int count = 0, row = 0, column = matrix[0].length-1;
        
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