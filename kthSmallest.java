// Time Complexity : O(n * log(max_value - min_value)) n is number of elements in array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix.length;
        int low = matrix[0][0];
        int high = matrix[l-1][l-1];
        int[] smallAndLarge = new int[2];
        
        
        while(low < high){
            int mid = low + (high - low)/2;
            smallAndLarge[0] = low;
            smallAndLarge[1] = high;
            int count = this.findCount(matrix, mid, smallAndLarge);
            if(count==k)
                return smallAndLarge[0];
            if (count < k) low = smallAndLarge[1]; // search higher
            else high = smallAndLarge[0]; // search lower
            
        }
        return low;
    }
    
    private int findCount(int[][] matrix, int mid, int[] smallAndLarge){

        int count = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                
                if(matrix[i][j]<=mid){
                    count = count + 1;
                    smallAndLarge[0] = Math.max(smallAndLarge[0],matrix[i][j]);
                }
                else{
                    smallAndLarge[1] = Math.min(smallAndLarge[1],matrix[i][j]);
                }
            }
        }
        return count;
    }
}