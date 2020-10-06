// Time Complexity : O(n*m log k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0)
            return -1;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                maxHeap.add(matrix[i][j]);
                
                if(maxHeap.size()>k){
                    maxHeap.remove();
                }
            } 
        }
        
        return maxHeap.peek();
    }
}