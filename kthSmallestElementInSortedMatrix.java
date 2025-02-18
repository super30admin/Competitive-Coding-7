import java.util.PriorityQueue;
//378. Kth Smallest Element in a Sorted Matrix
//Tc O(n + k log n)
//Sc O(n)

class kthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int m = matrix.length;
        int n = matrix[0].length;
//Traverse the matrix and to max heap. if heap size > k poll the max element in heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}