// Time Complexity : O(n^2)
// Space Complexity : O(log k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        int max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size()>k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
