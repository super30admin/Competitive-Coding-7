/*
T - O(n^2logk)
S  - O(K)
 */
class Solution {
    /*
    [1, 5,  9]
    [10,11,13]
    [12,13,15]
    [15, 13,13,12, 11, 10, 9, 5]
    */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                if(pq.size()<k){
                    pq.offer(matrix[i][j]);
                }
                else{
                    if(pq.peek()>matrix[i][j]){
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        return pq.poll();

    }

}