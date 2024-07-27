import java.util.PriorityQueue;

class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else if(pq.size() == k) {
                    if(matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }

        if(!pq.isEmpty()) {
            return pq.poll();
        }
        return -1;
    }
}
