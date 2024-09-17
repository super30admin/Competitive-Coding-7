//Time Complexity: O(m*n) where m & n -> no of rows & columns
//Space Complexity: O(m*n)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0)
            return -1;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        //Using Max Heap to insert the elements in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        
        //adding elements in maxHeap
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                maxHeap.add(matrix[i][j]);
            }
        }
        int total = n*m;
        
        for(int i=0; i<total-k; i++)
        {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
}
