public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        while(start<=end){
            int mid = start + (end-start)/2;
            int count = helper(matrix,mid);
            if(count<k) start=mid+1;
            else end = mid-1;
        }
        return start;
    }
    private int helper(int[][] matrix, int num){
        int row = 0, col = matrix[0].length-1, count=0;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]<=num){
                count+=col+1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
}

// Time Complexity - O(logn)
// Space Complexity - O(1)
