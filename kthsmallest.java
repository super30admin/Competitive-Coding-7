// TC : O(klogn)
// SC : O(n)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length ==0) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}