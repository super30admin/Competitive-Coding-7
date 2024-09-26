
// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//TC : O(nlogk)
//SC: O(1)
public int KthSmallest(int[][] matrix, int k) {
    
    if(matrix == null || matrix.Length == 0)
        return 0;
    
    int m = matrix.Length;
    int n = matrix[0].Length;
    int low = matrix[0][0];
    int high = matrix[m-1][n-1];
    
    while(low <= high)
    {
        //calculate mid of vaues , not indexes
        int mid = low + (high - low)/2;
        
        //get teh rank of mid, so that we cna decide 
        //if k is smaller than mi, then we need to go right, else left.
        int rank = getRank(matrix, mid, m, n);
        if(rank < k)
            low = mid + 1;
        else
            high = mid - 1;
    }
    
    return low;
}

private int getRank(int[][] matrix, int target, int m, int n)
{
    int j = n-1;
    int count = 0;
    for (int i = 0; i < m; i++)
    {
        while (j >= 0 && matrix[i][j] > target)
            j--;
        count += j + 1;
    }
    return count;
}


//TC : O(nlogk)
//SC: O(n)
public int KthSmallest(int[][] matrix, int k) {
    
    if(matrix == null || matrix.Length == 0)
        return 0;
    
    PriorityQueue<int, int> pq = new PriorityQueue<int, int>(Comparer<int>.Create((x, y) => y - x));
    
    for(int i = 0; i < matrix.Length; i++)
    {
        for(int j = 0; j < matrix[0].Length; j++)
        {
            pq.Enqueue(matrix[i][j], matrix[i][j]);
            if(pq.Count > k)
                pq.Dequeue();
        }
    }
    return pq.Peek();
}