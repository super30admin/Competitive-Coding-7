// Time Complexity : O(log(diff)*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1]; int ans = 0;
        while(lo <= hi){ // taking min and max and performing binary search
            int mid = lo + (hi - lo)/2;
            int x = helper(matrix,mid);
            if(x >= k){
                hi = mid - 1;   // finding minimum ans, with count k
                ans = mid;
            }
            else
                lo = mid + 1;
        }
        return ans;
    }
    private int helper(int[][] matrix,int target){
        int n = matrix.length; int cnt = 0;
        int j = n - 1; int i = 0;
        while( i < n && j >= 0) { // taking element in first row and last column and iterating it.
            if(matrix[i][j] < target){
                i++;
                cnt += j + 1;}
            else{
                while(j >=0 && matrix[i][j] > target)
                    j--;
                if(j >= 0)
                    cnt += j + 1;
                i++;
            }
        }
        return cnt;
    }
}