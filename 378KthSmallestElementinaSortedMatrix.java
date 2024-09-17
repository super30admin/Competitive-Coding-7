// n log k
// sc: o(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low < high){
            int mid = low + (high-low)/2;
            int count = count(matrix, mid);
            
            if(count < k){
                low = mid+1;
            }else{
                high = mid;
            }
            
        }
        return low;
    }
    
    public int count(int matrix[][], int mid){
        
        int count = 0;
        int j = matrix.length - 1;
        
        System.out.println("Mid: " +mid);
        
        for(int i =0 ; i< matrix.length;i++){
            
            while(j >= 0 && matrix[i][j] > mid)
            {
                System.out.println("Element: "+matrix[i][j]);
                j--;
            
            }
            count+= j+1;
            
            System.out.println("count: " + count);
        }
        return count;
    }
}