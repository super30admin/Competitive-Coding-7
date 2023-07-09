import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallestElementInMatrix solution = new KthSmallestElementInMatrix();

        // Test Case 1
        int[][] matrix1 = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k1 = 8;
        int result1 = solution.kthSmallest(matrix1, k1);
        System.out.println("Kth Smallest Element: " + result1);

        // Test Case 2
        int[][] matrix2 = {
                { 1, 3, 5 },
                { 6, 7, 12 },
                { 11, 14, 14 }
        };
        int k2 = 3;
        int result2 = solution.kthSmallest(matrix2, k2);
        System.out.println("Kth Smallest Element: " + result2);
    }
}
