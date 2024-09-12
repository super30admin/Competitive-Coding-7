//Time complexity O(log(n))
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    
        if(matrix.length == 0 || k < 1 || matrix[0].length == 0 || matrix == null){
          //   System.out.println("hello");
            return Integer.MIN_VALUE;
        }
        int r = matrix.length;
        int c = matrix[0].length;
       int low = matrix[0][0];
        int high = matrix[r-1][c-1];
        
        while(low < high){
            
            int mid = low + (high - low) / 2;
            
            int count = calculateCount(matrix, mid, r, c);
           // System.out.println(count);
   
            
             if( count < k){
                
                low = mid + 1;
            }
            
            else {
                
                high = mid;
            }
        }
     
       
        return low ;
    }
    private int calculateCount(int[][] matrix, int mid, int r, int c){
        
        int count = 0;
       // int i = 0;
        
        
        for(int i = 0; i < r; i ++){
            
            int j = c - 1;
            while(j >= 0 && matrix[i][j] > mid){
            
                j--;
            }
            count = count + j + 1;
            //i ++;
           // j --;
        
            
        }
        return count;
    }
}