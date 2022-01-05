// Time Complexity :O((n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
         int n = matrix.length;
         int low = matrix[0][0], high = matrix[n-1][n-1];
        
    while(low < high){
        int mid = low + (high- low)/2;
        int counter = count(matrix, mid);
        if(counter < k) low = mid + 1;
        else 
            high = mid;
    }
        
     return low;   
    }
    public int count(int matrix[][] , int mid){
        int count = 0;
        int length = matrix.length;
        for(int i = 0; i< length; i++){
            int j = length-1;
            while(j>=0 && matrix[i][j] > mid) j--;
            
            count += j+1;
        }
        return count;
    }
    
}