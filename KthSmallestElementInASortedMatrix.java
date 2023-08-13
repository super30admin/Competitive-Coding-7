// Binary Search
// TC = O(n^2)
// SC = O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low < high){
            int count = 0;
            int mid = low + (high - low)/2;

            for(int i = 0; i< n; i ++){
                for(int j = 0; j<n; j++){
                    if(matrix[i][j] <= mid){
                        count++;
                    }
                }
            }

            if (count < k){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low;   
    }
}