//tc: O(m*n) log m*n -- building PQ
//sc: O(mn) log (m*n)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k == 0)
            return -1; // considering errors

        int m = matrix.length;
        int n = matrix[0].length;

        // build min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(matrix[i][j]);
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}