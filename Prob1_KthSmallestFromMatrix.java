//TC : O(N^2)

//SC : O(n) -- Using Queue 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //if(matrix == null)  return -1;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                queue.add(matrix[i][j]);
                
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }
        
        return queue.poll();
        
        
    }
}