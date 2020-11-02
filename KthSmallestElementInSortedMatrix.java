// Time Complexity : O(K log X), where X is min(k, n)
// Space Complexity : O(X)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// since rows are sorted in ascending order need to check kth least element from there
// form min heap of min(k, n) nodes
// keep popping least node and add next if j<n-1
// poll() k times 

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0) return 0;
        
        int n = matrix.length;
        int X = Math.min(n, k);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(X, (int[] e1, int[] e2) -> (e1[2]-e2[2]));
        
        for(int i=0; i<X; i++){
            pq.add(new int[]{i, 0, matrix[i][0]});
        }
        
        while(k>1){
            int[] e = pq.poll();
            if(e[1]<n-1){
                int i = e[0];
                int j = e[1]+1;
                pq.add(new int[]{i, j, matrix[i][j]});
            }
            k--;
        }
        
        
        return pq.poll()[2];
    }
}