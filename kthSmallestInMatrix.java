// Time complexity = O(m*n), where m is no. of rows, n = no. of coloumns
// Space complexity = O(k), for the max heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int m = matrix.length, n = matrix[0].length;

        // iterate over the matrix and store in a max heap of size k
        for (int i=0; i<m ; i++) {
            for (int j=0; j<n ; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}

// Approach 2: If we want O(1) space: Use binary search
// Time complexity = O((m*n)log(m*n)), where m is no. of rows, n = no. of coloumns, log (m*n) for binary search
// Space complexity = O(1)
class Solution {
    int m,n;
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;

        m=matrix.length;
        n=matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];

        while (low < high) {
            int mid = low + (high-low)/2;
            int count = getCount(matrix, mid);
            if (count < k) {
                low = mid+1;
            }
            else {
                high = mid;
            }
            if (low == high) {
                return low;
            }
        }
        return low;
    }

    private int getCount(int[][] matrix, int mid) {
        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (matrix[i][j] <= mid) {
                    count++;
                }
            }
        }

        return count;
    }
}