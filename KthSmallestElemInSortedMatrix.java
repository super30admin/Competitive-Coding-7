package Nov30;

class KthSmallestElemInSortedMatrix {
    
    /*
    Time complexity: O(n^2 log n) 
    Space complexity: O(1)

    Approach: Binary Search used.
    
    */
    
    public int kthSmallest(int[][] matrix, int k) {
        // edge
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        
        // perform binary search  : O(log n)
        while (start < end) {
            int mid = start + (end-start)/2;
            int count = findCount(matrix, mid);
            if (count < k) {
              start = mid+1;  
            } else  {
              end = mid;
            } 
        }
        return start;
    }
    
    // helper method to find count of elements in matrix <= mid 
    // time comp : O(n^2)
    public int findCount(int[][] matrix, int mid) {
        
        int n = matrix.length;
        int count = 0;
        // loop across each row
        for (int i = 0; i < n; i++) {
            // loop across each column from n-1 to 0
            // check if matrix[i][j] > mid
            // if yes:  
            //      decrement j and check for matrix[i][j] > mid condition again.
            int j = n-1;
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
             // once all elements in columns from n-1 to 0 are checked for the current row(i value) , update count variable
            count = count+(j+1);
        }
        
        return count;
    }
    
}