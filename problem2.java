//Time: O(N^2Log(N))
//Space:O(N)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> q = new PriorityQueue<>(k, (i, j) -> Integer.compare(j, i));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                q.offer(matrix[i][j]);

                if (q.size() > k) {
                    q.poll();
                }
            }
        }

        return q.poll();
    }
}