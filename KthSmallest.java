// Time Complexity : O(n logk) sort k elements - k is the # of rows, n - # of cells in the matrix
// Space Complexity : O(k) where k - # of cols in the matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> matrix[a[0]][a[1]]-matrix[b[0]][b[1]]);
        for(int j =0;j<matrix.length;j++)
            heap.add(new int[]{j,0});
        while(!heap.isEmpty()){
            int[] n = heap.poll();
            k--;
            if(k == 0) return matrix[n[0]][n[1]];
            if(n[1]+1 < matrix[0].length)
                heap.add(new int[]{n[0],n[1]+1});
            }
        return -1;
    }
}
