class Solution {
    //Using Binary Search
    //TC: O(nlogn)
    //SC: O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1], mid;

        while(low < high){
            mid = low + (high - low)/2;
            int counter = count(matrix,mid);
            if(counter < k) low = mid+1;
            else high = mid;
        }
        return low;
    }
    public int count(int matrix[][], int mid){
       
        int count  = 0;
        for(int i =0; i < matrix.length; i++){
            int j = matrix.length - 1;
            while(j >=0 && matrix[i][j] > mid) j--;
            count +=j+1;
        }
        return count;
    }
}