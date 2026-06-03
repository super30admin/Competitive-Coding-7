//Time Complexity: O(k * log m) 
//Space Complexity: O(m)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < m; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int[] curr = new int[2];
        int val = 0;

        while (k > 0) {
            k--;
            curr = pq.poll();

            val = curr[0]; 
            int r = curr[1]; 
            int c = curr[2]; 

            if (c + 1 >= n) continue;

            int nextVal = matrix[r][c + 1];
            pq.add(new int[]{nextVal, r, c + 1});
        }

        return val;
    }
}