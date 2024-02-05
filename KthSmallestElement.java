class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b) -> b - a);
        int n= matrix.length;
        int m= matrix[0].length;
        int arr[]=new int[n*m];
        
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(pq.size()<k){
                    pq.add(matrix[i][j]);
                }
                else{
                    if(matrix[i][j]<pq.peek()){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
        
    }
}