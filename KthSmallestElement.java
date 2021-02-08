
// Time : O(NxM) : Time to traverse a 2D matrix
// Space : O(K) : PriorityQueue
// Leetcode : YES


class KthSmallestElement {
    // Using a priority queue
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null) return -1;
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            
        }
        return pq.poll();
    }
}
