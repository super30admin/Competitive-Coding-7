
// Time Complexity : O(klogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    public static int kthSmallest(int[][] matrix, int k) {
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // size of the matrix
        int n = matrix.length;
        // add first column into the pq
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { matrix[i][0], i, 0 });
        }
        // maintain a counter for checking kth smallest element
        int count = 0;
        int result = -1;
        // while loop until the kth smallest element
        while (count < k) {
            int[] min = pq.poll();
            // increase counter as we poll minimum element from the queue
            count++;
            // System.out.println(Arrays.toString(min));
            // result update at every loop
            result = min[0];
            // currentROw of min element
            int curRow = min[1];
            // current column of min element
            int curCol = min[2];
            // if current column is less than n-1;
            if (curCol < n - 1) {
                // add next element in currentRow in pq
                pq.add(new int[] { matrix[curRow][curCol + 1], curRow, curCol + 1 });
            }
        }

        // return result
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}