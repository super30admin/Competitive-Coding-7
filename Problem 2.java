//Time Complexity: O(n log n)
//Space Complexity: O(1)

//Successfully runs on leetcode: 0 ms

//Approach: Here we use Binary Search algo based on values. We first find mid value and check the number of elements in the
//matrix less than mid. If the count is equal to k, we return the mid. If the count < k, we move the left pointer to mid+1,
//else we move the right to mid - 1.

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        //edge
        if(matrix.length == 0 || matrix == null) return -1;
        int len = matrix.length;
        int l = matrix[0][0];
        int r = matrix[len - 1][len-1];
        
        while(l < r)
        {
            int mid = l + (r - l)/2;
            if(count(matrix, mid) < k)
            {
                l = mid+1;
            }
            else
                r = mid;
        }
        return l;
    }
    
    private int count(int[][] matrix, int middle)
    {
        int r = 0; int c = matrix.length - 1; 
        int countR = 0;
        
        while(r < matrix.length && c >= 0)
        {
            if(matrix[r][c] <= middle)
            {
                r++;
                countR += c+1;
            }
            else
                c--;
        }
        return countR;
    }
}