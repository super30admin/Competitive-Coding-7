class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix ==  null || matrix[0].length == 0 || 
           matrix[0] == null || matrix[0].length == 0)
            return 0;
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low < high){
            int mid = low + (high - low) / 2;
			
            if(count(matrix, mid, n) < k) 
                low = mid + 1;
            else
                high = mid;
        }
        
        return low; 
    }

    public int count(int[][] matrix, int mid, int n){
        int row = 0;
        int col = n - 1;
        int count = 0;
        
        while(row < n && col >= 0){
            if(matrix[row][col] <= mid){ 
                row++;
                count += (col + 1); 
            }else{
                col--;
            }
        }
        return count; 
    }
}


//Time Complexity = O(log(max - min))
//Space Complexity = O(1)
