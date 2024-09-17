//Time Complexity : O(mnLogk), m*n-> Size of Matrix,
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }

            }
        }
        return pq.peek();
    }
}