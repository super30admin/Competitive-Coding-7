/*
The following code uses two binary search algorithms to solve the problem within the given time and space bounds.
In the first algorithm, we try to get the Kth smallest element by trying to find the location in the matrix where
the amount of numbers less than the number at that location is equal to k - 1. To find the amount of numbers lesser
than that number at that location, we use another binary search algorithm.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(nlog(max - min))
    //Space Complexity: O(1)
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            int cnt = getCnt(matrix, mid);
            
            if(cnt < k)
                low = mid + 1;
            
            else
                high = mid - 1;
        }
        //At the end of the search the algorithm has the answer at the lower value
        return low;
    }
    
    private int getCnt(int matrix[][], int mid)
    {
        int n = matrix.length;
        
        int i = n - 1;
        int j = 0;
        
        int cnt = 0;
        
        while(i >= 0 && j < n)
        {   //We keep a count of how many numbers are less than or equal to the number we are finding, as we find the number
            //We only do this when the number is greater than the current matrix location, as we know decisively that all 
            //the numbers above the location are less than the number, on account of it being a sorted 2D matrix
            if(mid >= matrix[i][j])
            {
                cnt += i + 1;
                j++;
            }
            else
                i--;
        }
        
        return cnt;
    }
}