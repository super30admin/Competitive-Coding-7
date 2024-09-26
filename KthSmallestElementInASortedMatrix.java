//TC:O(N×log(Max−Min))
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if ( matrix == null || matrix.length == 0)
            return Integer.MIN_VALUE;
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while ( low < high){
            int mid = low + (high-low)/2;
            int count = getCount(matrix, mid);
            if (count < k){
                low = mid+1;
            } else {
                high = mid;
            } 
        }
        return low;
    }
    private int getCount(int[][] matrix, int mid){
        int count = 0;
        int j = matrix.length-1;
        for (int i = 0; i < matrix.length; i++){
            while (j >= 0 && matrix[i][j] > mid){
                j--;
            } 
            count = count + (j+1);
        }
        return count;
    }
}
