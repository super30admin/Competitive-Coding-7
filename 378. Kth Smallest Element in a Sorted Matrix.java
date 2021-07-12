class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Time complexity: O(nlogn)
        // Space complexity: O(1)
        // binary search method
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(countLessOrEqual(mid, matrix) < k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
    
    public int countLessOrEqual(int mid, int[][] matrix){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] <= mid){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}