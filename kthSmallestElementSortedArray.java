// Time Complexity : O(2nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    int m;
    int n;
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0 || matrix==null){
            return 0;
        }
        
        m = matrix.length;
        n = matrix[0].length;
        
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println("mid: "+mid);
            if(helper(mid, matrix)<k){
                low = mid+1;
                System.out.println("low: "+low);
            }else{
                high = mid-1;
                System.out.println("high: "+high);
            }
        }
        return low;
    }
    
    private int helper(int mid, int[][] matrix){
        int row = 0;
        int col = n-1;
        
        int count = 0;
        
        while(row<n && col>=0){
            System.out.println("row: "+row);
            System.out.println("col: "+col);
            if(mid>=matrix[row][col]){
                // col--;
                row++;
                count +=col+1;
                System.out.println("count: "+count);
                
                // count += col+1;
            }else{
                // row++;
                col--;
                // count +=col+1;
            }
        }
        return count;
    }
}