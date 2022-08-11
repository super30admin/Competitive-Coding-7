//Time Complexity: O(N*log(max - min)); where N is total elements, max is maximum element, min is minimum element.
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        int mid = 0;
        
        while(low <= high){
            
            mid = low + (high -low)/2;
            
            int count = getCount(matrix, mid);
            
            if(count >= k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low;
    }
    
    private int getCount(int[][] matrix, int mid){
        
        int j = matrix.length -1;
        int count = 0;
        
        for(int i =0; i < matrix.length; i++){
            
            while(j >=0 && matrix[i][j] > mid)
                j--;
            
            count += j+1;
        }
        
        return count;
    }
}
