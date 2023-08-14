// Time Complexity : O(n) + O(log(max - min))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Min element is at 0,0 index and max element m-1, n-1 index.
 * 2. Find the mid of the min and max and find how many elements are less than mid.
 * 3. If count is less than k then move low to mid + 1 else move high to mid.
 * 4. Return low ot high.
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];

        while(low < high){
            int mid = low + (high-low)/2;
            int count = valuesCount(matrix, mid);
            if(count < k){
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        return low;
    }

    private int valuesCount(int[][] matrix, int value){
        int row = 0, col = matrix[0].length - 1;
        int count = 0;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] <= value){
                count += col + 1;
                row++;
            }else {
                col--;
            }
        }

        return count;
    }
}