/**
 * Time complexity: O(Nlog (Max - Min)) where N is size of matrix, Max is maximum element in matrix
 *                  and Min in minimum element in matrix 
 * Space complecity: O(1) 
 * 
 * Approach:
 * 1. Since the matrix is sorted we can do binary search for the range of min to max in matrix.
 * 2. We can count number of elements less than mid and keep on repeating binary search till the count 
 * reaches to k.
 */
class KSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0){
            return -1;
        }
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int count = 0;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            count = countNos(matrix, mid);
            
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
        
    }
    
    private int countNos(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length-1;
        
        for(int i = 0; i<matrix.length; i++) {
            while(j >= 0 && matrix[i][j] > mid){
                j--;
            }
            count += (j+1);
        }
        
        return count;
    }
    
    
}