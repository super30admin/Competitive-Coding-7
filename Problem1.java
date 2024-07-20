/*
    LC - 378. Kth Smallest Element in a Sorted Matrix
    TC - O(N^2 * log K)
    SC - O(K)
    Approach - 
        Using max heap
        store k elements in the priority queue.
        more than k, if any incoming elements is smaller than peek
        then poll and add the elements in the heap.
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = matrix.length;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }else{ 
                    if(matrix[i][j] < pq.peek()){ 
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        
        return pq.peek();
    }
}