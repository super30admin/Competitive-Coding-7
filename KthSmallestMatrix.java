//time - O(n^2) since we are going through all the elements ina  matrix
//space- O(k)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i =0; i< m ; i++){
            for(int j =0 ; j<n ; j++){
                pq.add(matrix[i][j]);
                if(pq.size()> k){
                    pq.poll();
                }
            }
        }
        
        return pq.poll();
    }
}