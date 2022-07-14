// Time Complexity : O(nlogn) 
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        
        while(min != max){
            int mid = min + (max - min) / 2;
            int count = countLessOrEqual(matrix, mid);
            if(count < k){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    public int countLessOrEqual(int [][] matrix, int mid){
        int count = 0;
        int column = matrix.length - 1;
        int row = 0;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] <= mid){
                count += column + 1;
                row++;
            } else{
                column--;
            }
        }
        return count;
    }
}