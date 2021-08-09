//Time: O(N^2 log(k)) where k is the range
//Space: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        
        while(lo < hi){
            int mid = lo + (hi - lo) /2;
            int counter = count(matrix, mid);
            if(counter < k) lo = mid + 1;
            else hi = mid;
            
        }
        
        return lo;
    }
    
    public int count(int matrix[][], int mid){
        
        int count = 0;
        int len = matrix.length - 1;
        int j = len;
        for(int i = 0; i <= len; i++){
            
            while( j >= 0 && matrix[i][j] > mid){
                j--;
            }
            count += j + 1;
        }
        
        return count;
    }
}