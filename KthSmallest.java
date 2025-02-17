import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a)); // Max Heap
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(ints[j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
