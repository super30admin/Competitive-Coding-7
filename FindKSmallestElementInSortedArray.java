class Solution {
    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> matrix[a.row][a.col] - matrix[b.row][b.col]);
        int n = matrix.length;
        for(int i = 0; i < n && i < k; i++) {
            pq.add(new Node(i, 0));
        }

        int count = 0, result = 0;

        while(!pq.isEmpty()) {
            Node e = pq.poll();
            result = matrix[e.row][e.col];

            count++;
            if(count == k) {
                break;
            }

            e.col++;
            if(e.col < n) {
                pq.add(e);
            }

        }
        return result;

    }
}