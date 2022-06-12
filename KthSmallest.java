/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        
        for(int i=0; i<rows; i++)
        {
            for(int j =0 ; j < cols; j++)
            {
                queue.add(matrix[i][j]);
            }
        }
        
        int result = 0;
        
        for(int i =1 ;i <k; i++)
        {
            queue.poll();
        }
        
        
        return queue.poll();
        
        
    }
}