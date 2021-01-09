// Time Complexity : O(log(max(matrix) - min(matrix)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : count in getCount function


// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length - 1;
        
        int lo = matrix[0][0], hi = matrix[n][n];
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2 ;
            int lessNumbers = getCount(matrix, mid);
            
             if(lessNumbers < k) {
                lo = mid + 1;
            }
            else 
                hi = mid;
            
        }
        return lo;
    }
    
    public int getCount(int[][] matrix, int k) {
        int count = 0;
        int n = matrix.length - 1;
        int j = n;
        for(int i = 0; i <= n; i++) {
            while(j >= 0 && matrix[i][j] > k) { 
                j--;
            }
            count += j+1;
        }
        // System.out.println(k + "  " + count);
        return count;
    }
    
    
}