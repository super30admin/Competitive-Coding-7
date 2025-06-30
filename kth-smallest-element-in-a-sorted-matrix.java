//Max-heap:
//Maintain a max-heap of size k containing the k smallest elements seen so far.
//While iterating over all elements:
//- Add the current element to the heap.
//- If the heap size exceeds k, remove the largest element (the root of the max-heap).
//At the end, the heap contains exactly k smallest elements, and the root is the kth smallest element.
// Time Complexity: O(m*n log k) where m is the number of rows, n is the number of columns in the matrix.
// Space Complexity: O(k) for the heap.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; //rows
        int m = matrix[0].length; //cols
        // Max-heap: largest element on top
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(matrix[i][j]);
                // Keep heap size at most k
                if (pq.size() > k) {
                    pq.poll();  // remove largest element in the heap
                }
            }
        }
        return pq.peek();
    }
}

// Binary Search: Top-right Binary Search on range/answer/values
//For each mid, count elements ≤ mid using the matrix’s sorted rows + columns by sweeping from the top-right.
//Adjust low or high until they converge on the smallest number with at least k elements ≤ it → that number is the kth smallest.
// Time Complexity: O(n log(max-min)) where n is the number of elements in the matrix.
// Space Complexity: O(1), no extra space used.

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];             // smallest number in matrix
        int high = matrix[n - 1][n - 1];    // largest number in matrix

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int col = n - 1;  // start from top-right corner
            for (int row = 0; row < n; row++) {
                while (col >= 0 && matrix[row][col] > mid) {
                    col--;
                }
                count += (col + 1);  // elements ≤ mid in this row
            }
            if (count < k) {
                low = mid + 1;       // kth smallest must be bigger
            } else {
                high = mid;          // mid could still be kth smallest
            }
        }
        return low;  // or high, since low == high
    }
}
