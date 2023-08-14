// Time Complexity : O(N log(Max - Min))
// Binary Search is between Max value and min value in 2d matrix.  So it takes log(Max - Min)
//In each search  we are counting number of elements before mid over 2d matrix which is m*n/2 -> N
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class KthSmallestIn2DMatrixUsingBinarySearch {

    public int kthSmallest(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m-1][n-1];

        while(low < high)
        {
            int mid = low + (high-low)/2;

            int count = getCount(matrix,m,n,k,mid);

            if(count<k){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return low;

    }

    public int getCount(int[][] matrix, int m, int n, int k, int mid)
    {
        int count = 0;
        for(int i=0; i<m; i++)
        {
            int j=0;
            while(j<n && matrix[i][j] <= mid)
            {
                count++;
                j++;
            }
        }
        return count;
    }
}
