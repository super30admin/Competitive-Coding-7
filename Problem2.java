/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(NlogN)

The idea is to use heap to return the kth element.
**/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       
        int row = matrix.length;
        int col = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< row; i++){
            for(int j = 0; j<col; j++){
                pq.add(matrix[i][j]);
            }
        }
        
        int i  = 0;
        while(true){
            if(i == pq.size()- k)
                return pq.peek();
            pq.poll();
        }
        
    }
}
