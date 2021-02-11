/**
Leetcode: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/


Given an n x n matrix where each of the rows and columns are sorted in ascending order, 
return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th largest number is 13

Time Complexity : O(N*N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int length = matrix.length;
        
        
        int low = matrix[0][0];
        int high = matrix[length -1][length -1];
        
        while(  low < high)
        {
            
            int mid = low + (high-low)/2;
            
            int count = this.getCount( matrix, mid);
            
            if( count < k)
            {
                low = mid +1;
            }
            else
            {
                high = mid;
            }
        }
        
        return low;
    }
    
    public int getCount( int matrix[][], int target)
    {
        int count = 0;
        int length = matrix.length;
        int j = length;
        
        for( int i =0; i< length; i++)
        {
            while( j >= 0 && matrix[i][j] > target) j--;
            
            count = count + j + 1;
        }
        
        return count;
    }
}