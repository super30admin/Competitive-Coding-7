/** Time Complexity: O(n^2log(n^2))
 * Space Complexity: O(n-k+1)
 * Executed on leetcode : yes
 * approach: kth smallest element means n-k+1th largest element, so we take a min heap of that size and keep on adding elements of the matrix, as soon as heap is already full and we are going to drop in a new element, we pop the heap after heapify is done 
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        int heap_size = (matrix[0].length*matrix.length)-k+1;
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                min_heap.add(matrix[i][j]);
                if(min_heap.size()>heap_size) min_heap.poll();
            }
            
        }
        return min_heap.peek();
    }
}