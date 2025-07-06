class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left + (right - left)/2;
            int c = count(matrix, mid);
            if(c < k){
                left = mid + 1;
            }else right = mid;
        }
        return left;
    }

    private int count(int[][] mat, int mid){
        int j = mat.length - 1;
        int count = 0;

        for(int i = 0; i < mat.length; i++){
            while(j >= 0 && mat[i][j] > mid){
                j--;
            }
            count += j+1;
        }

        return count;
    }
}
