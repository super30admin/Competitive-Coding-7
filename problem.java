class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 ) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        
        return pq.poll();
    }
}

//time complexity O(m^2 log k)
//space complexity O(k)