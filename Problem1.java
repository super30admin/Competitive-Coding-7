
// Time - O (n log k)
// Space - O(logk)


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix == null) return 0;

        int n = matrix.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < n; i++) {

            for( int j = 0; j < n; j++) {

                pq.add(matrix[i][j]);

                if(pq.size() > k) {
                    pq.poll();
                }

            }

        }

        return pq.peek();

    }
}