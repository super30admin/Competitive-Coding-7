// Time Complexity : O(nxm) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  No


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int low = matrix [0][0];
        int high = matrix[n-1][n-1];
        
        while(low<high)
        {
             int mid = (low+high)/2;
             if(count(matrix,mid)<k)
             {
                 low = mid+1;
             }
             else
             {
                 high = mid;
             }
        }
        
        return low;
        
       
        
    }
    
    private int count(int[][] matrix, int mid)
    {
        int length = matrix.length;
        int count =0;
        for(int i = 0 ; i < length;i++)
        {
            int j = length-1;
            while(j>=0 && matrix[i][j]>mid) j--;
            count+=j+1;
        }   
        return count;
    }
}