// Time Complexity : O(nlog(max-min))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initialize Range: Start with the smallest (low) and largest (high) elements in the matrix.
// Binary Search: Perform binary search on this range. For each middle value (mid) in the range:
// Count Elements: Count how many elements in the matrix are less than or equal to mid.
// Adjust Range: If the count is less than k, move the low up to mid + 1; otherwise, move the high down to mid.
// Return Result: When low equals high, that's the k-th smallest element.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];

        while(low < high){
            int mid = low +(high-low)/2;
            int count =0;
            int j=matrix[0].length-1;
            for(int i=0; i<matrix.length; i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                count = count+(j+1);
            }
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;

    }
}