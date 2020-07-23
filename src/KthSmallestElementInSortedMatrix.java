// Time Complexity : O(n log (n^2))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
 * 
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //edge case
        if(matrix == null || matrix.length == 0) return -1;
        
        int n = matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];
        
        //run binary search on first and last element of matrix as range, 
        // find count of elements which are equal or less than mid, if count less than k, change low else change high
        while(low < high){

            int mid = low + (high-low)/2;
            int count = count(matrix, mid);
            
            if(count<k) {
                low = mid + 1;
            }else {
                high = mid;
            }
            
        }
        
        return low;
    }
    
    //find count of elements which are less or equal compared to mid
    // start from last element of each row, if its less than or equal to mid, all those into count
    //else till its large than mid, decrease column (j)
    private int count(int[][] m, int mid){
        
        int cnt = 0, j = m.length - 1;
        
        for(int i=0; i< m.length; i++){
            
            while(j>=0 && m[i][j] > mid) {
                j--;
            }
            
            cnt = cnt + j + 1;
        }
        
        return cnt;
    }
}