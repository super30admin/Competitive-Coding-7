// Time Complexity : O(n x m logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                int len = queue.size();
                if(len < k){
                    queue.add(matrix[i][j]);
                }else{
                    if(matrix[i][j] < queue.peek()){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }
}
