//Time Complexity : O(nLogk)
//Space Complexity : O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        //null
        if(matrix == null || matrix.length == 0)
        {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        
        while(low < high)
        {
            int mid = low + (high - low)/2;
            
            int count = countElements(mid,matrix);
            
            if(count < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int countElements(int element,int mat[][])
    {
        int n = mat.length;
        
        //Starting from right top corner
        int row = 0;
        int col = n-1;
        int count = 0;
        
        while(row < n && col>=0)
        {
            if(mat[row][col] <= element)
            {
                count += col + 1;
                row++;
            }
            else
            {
                col--;
            }
        }
        
        return count;
    }
}