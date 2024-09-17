/**

TC - O(n*n) + O(KlogK) where n is the number of elements in matrix.
SC - O(K) size of the maxHeap.

**/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        final Queue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                priorityQueue.add(matrix[i][j]);
                
                if (priorityQueue.size() > k)
                {
                    priorityQueue.remove();
                }
            }
        }
        
        return priorityQueue.peek();
    }
}
