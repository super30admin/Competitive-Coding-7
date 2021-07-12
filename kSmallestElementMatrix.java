// Time Complexity : O(N) 
// Space Complexity : O(N) MinHeap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add all the elements to a min heap
2. Remove elements till k-1
3. The next element will be the kth smallest element.
*/


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int currentNum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> b-a );
        
        int totalElements = m*n;
        
        if(k>totalElements) return -1;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                minHeap.add(matrix[i][j]);
                if(minHeap.size() > k) minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}
