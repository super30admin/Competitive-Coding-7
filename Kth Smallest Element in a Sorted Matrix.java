// Time Complexity : O((nlog(k)); where k is provided as an input
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)    return 0;

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a) ;

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

// Time Complexity : O((nlog(n-k)); where k is provided as an input
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)    return 0;

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;

        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < matrix.length; i ++)
        {
            for(int j = 0 ; j < matrix[0].length; j++)
            {
                pq.add(matrix[i][j]);
                if(pq.size() > (matrix.length * matrix[0].length) - k)
                {
                     max = Math.max(max, pq.poll());
                }
            }
        }
        return max;  
    }
}


