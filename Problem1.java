//kth smallest element in a sorted matrix https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//Time complexity : O(log(N) + N)
//Space Complexity: O(1)

/**
 * Using a binary search approach, we will calculate the less or equal elements for k value. By doing this, we are limiting search space
 * since our matrix is sorted already. After, that low pointer will be at the position where our range becomes equal to k.
 */

class Problem1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low<high){
            int mid = low + (high -low)/2;

            int range;
            range = lessorEql(matrix, mid);
            if(range <k){
                low = mid +1;

            }
            else{
                high = mid;
            }
        }
        return low;
    }

    private int lessorEql(int[][] matrix, int target){

        int c=0;
        int m = matrix.length;
        int i = m-1;
        int j =0;

        while(i>=0 && j<m){

            if(matrix[i][j] > target){
                i--;
            }
            else{
                c += i+1;
                j++;
            }

        }
        return c;
    }
}
