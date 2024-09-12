/*
method- 1
use max priority queue(max heap) to find the kth smallest element
time complexity : O(m x n), worst case end up traversing entrire matrix

space complexity : O(k), using max pq to maintain k elements
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}