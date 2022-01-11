// Time complexity = O((m*n)log(m*n)), where m is no. of rows, n = no. of coloumns, log (m*n) for binary search
// Space Complexity: o(1)
// Binary Search using values since we know answer >= matrix[0][0] and answer <= matrix[n-1][n-1]
// find elements less than or equal to mid and if the number of these elements equal K
public class KSmallestElementSortedMatrix 
{
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int r = matrix.length, c = matrix[0].length;
        int low = matrix[0][0], high = matrix[r-1][c-1];
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            // search number of elements <= mid
            int count = countElements(matrix, mid);
            if(count < k)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return low; // smallest element will be at low as we narrowed the search
    }
    
    // search in 2D sorted matrix II
    private int countElements(int[][] matrix, int val)
    {
        int count = 0, j = matrix[0].length -1;
        for(int i = 0 ; i < matrix.length; i++)
        {
            while(j >= 0 && matrix[i][j] > val)
            {
                j--;
            }
            count += j+1; // entire row is <= mid so add row length+1 count
        }
        
        return count;
    }
}

// Time Complexity: O(nlogk) time to make priority queue on matrix
// Space Complexity: o(k)
// Priority Queue
public class KSmallestElementSortedMatrix 
{
    public int kthSmallest(int[][] matrix, int k)
    {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        // Max Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a) ;
         
        for(int i = 0 ; i < matrix.length; i ++)
        {
            for(int j = 0 ; j < matrix[0].length; j++)
            {
                pq.add(matrix[i][j]);
                if(pq.size() > k)
                {
                    pq.poll();
                }
            }
        }
        return pq.peek();  
    }
}