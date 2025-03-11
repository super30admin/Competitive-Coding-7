// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Time Complexity : O(nlogk) - binary search
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take low as the element at 0,0 and high as element at m-1, n-1. While low<high find mid and find the count of elements before
 * mid and if count is lessthan k then move low to mid + 1 and perform the same and when count will bw equal to k increase high to mid
 * and finally return low. To find the count take row as the last row and col as the 1st col and check if element at that place is
 * lessthan or equal to target which is mid, if yes take count of all the elements of that col i,e., row value+1 and increase col else
 * decrease row by 2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while(low<high){
            int mid = low + (high - low)/2;
            int count = numberElements(matrix, mid);
            if(count<k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
            
        }
        return low;
    }
        private int numberElements(int[][] matrix, int target){
            int m = matrix.length;
            int n = matrix[0].length;
            int row = m-1;
            int col = 0;
            int count = 0;
            while(row>=0 && col<n){
                if(matrix[row][col]<=target){
                    count += (row+1);
                    col++;
                }
                else{
                    row--;
                }
            }
            return count;
        }
}