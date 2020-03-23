// Time complexity - O(nlog(max - min)) Space - O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || k == 0){
            return 0;
        }
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int count = noLessThanEqualTo(matrix, mid);
            
            if(count < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        
        return low;
    
    }
    
    private int noLessThanEqualTo(int[][] matrix, int target){
        int n = matrix.length;
        int i = n - 1, j = 0;
        int result = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] > target) i--;
            else{
                result += i + 1; j++;
            }
        }
        
        return result;
    }
}