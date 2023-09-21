// Time Complexity : O(log N)  -> total no.of elements in matrix
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max= matrix[n-1][n-1];

        while(min != max)
        {
            int mid = min+(max-min)/2;
        
            int count = findCount(matrix, mid);
           
         if( count< k)
            min= mid+1;
            else
            max = mid;
        }
        return min;
    }

    public int findCount(int[][] matrix, int target)
    {
        int row =0, col = matrix.length-1;
        int count=0;
        while(row<matrix.length && col>=0)
        {
           if( matrix[row][col]<=target ){
               count+=col+1;
               row++;
           }
           else
           col = col-1;
        }
        return count;
    }

}