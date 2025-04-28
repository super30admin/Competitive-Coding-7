// Time Complexity : O(n log (m)) n->matrix size, m->(max - min) value range
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Apply binary search on the value range, from the smallest to the largest element.
// For each mid value, count how many elements are less than or equal to mid.
// Adjust the search range based on the count, and return smallest value where count is greater than or equal to k.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];
        while(low<high){
            int mid=low+(high-low)/2;
            int count=counter(matrix,mid,n);
            if(count<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }

    private int counter(int[][] matrix,int mid,int n){
        int count=0;
        int i=n-1,j=0;
        while(i>=0 && j<n){
            if(matrix[i][j]<=mid){
                count+=i+1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
}