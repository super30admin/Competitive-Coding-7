// Time Complexity : O(k logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    if(matrix == null || matrix.length == 0) return -1;

    int n = matrix.length;
    // Arrange in ascending order
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

    for(int i = 0; i<n; i++) {
      // Put into minHeap all the elements from the first column.
      minHeap.offer(new int[]{matrix[i][0], i, 0});
    }

    for(int i = 0; i<k-1; i++) {
      int[] currentSmallest = minHeap.poll();
      int row = currentSmallest[1];
      int column = currentSmallest[2];

      if(column+1<n) {
        // Put in the next element from the same row.
        minHeap.offer(new int[]{matrix[row][column+1], row, column+1});
      }
    }
    return minHeap.poll()[0];
  }
}