
public class KthSmallestElementinMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        int maxSize = (m * n) - k + 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                pq.add(matrix[i][j]);
                if (pq.size() > maxSize) {
                    pq.poll();
                }
            }
        }

        return pq.peek();

    }
}
