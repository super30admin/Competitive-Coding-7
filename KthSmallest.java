// Time Complexity : O(mn log mn)
// Space Complexity : O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = calculateCount(matrix, mid);
            if(count < k)
                low  = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    
    private int calculateCount(int[][]matrix, int mid){
        int count = 0;
        int j = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++){
            while(j >= 0 && matrix[i][j] > mid) j--;
            count += j + 1;
        }
        return count;
    }
}