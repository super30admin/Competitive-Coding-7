import java.util.PriorityQueue;

public class KthElementSortedMatrix {

    public int kthSmallest_BinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countNonBigger(mid, matrix);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countNonBigger(int target, int[][] matrix) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }

    public int kthSmallest_maxHeap(int[][] matrix, int k) {
        int m = matrix.length; //rows
        int n = matrix[0].length; //cols

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k)
                    pq.poll();

            }
        }

        return pq.peek();

    }

    public int kthSmallest_minHeap(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                minHeap.add(matrix[i][j]);
            }
        }


        while (k > 0) {
            k--;
            result = minHeap.poll();
        }
        return result;
    }
}
