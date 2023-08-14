// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/


// Time Complexity : O(n * log(n^2))

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        int count = 0;
        //Do binary search to find the number that has k-1 number of elements on the left
        while(start<end){
            int mid = start + (end-start)/2;
            count = cnt(matrix, mid);
            if(count < k) start = mid+1;
            else end = mid;
        }

        return start;
    }
//To count the number of elements on the left of a given number
    public int cnt(int[][] matrix, int mid){
        int n = matrix.length;
        int cnt = 0;
        int i=0;
        int j=n-1;
        while(i<n && j>=0){
            if(matrix[i][j] <= mid){
                i++;
                cnt = cnt+j+1;
            } else{
                j--;
            }
        }

        return cnt;
    }
}