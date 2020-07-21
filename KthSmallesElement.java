// Time Complexity : O(n^2 log k)
// Space Complexity : O(k). k is the number of smallest element 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix==null || matrix.length==0) return 0;
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<matrix.length;i++){
            
            for(int j=0;j<matrix[0].length;j++){
                
                pq.add(matrix[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        
        return pq.peek();
    }
}
