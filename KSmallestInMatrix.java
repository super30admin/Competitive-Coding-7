//Using min heap and comparison of min values
//T.C: O(N + K.logN ); N is number of rows in matrix;
//S.C: O(N)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int count=0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> a.get(0)-b.get(0));

        for(int i=0;i<matrix.length;i++){
            pq.add(Arrays.asList(matrix[i][0],i,0)); // adding value, row, col to keep track of next val in row

        }

        while(!pq.isEmpty() && count<k-1){
            List<Integer> currMin = pq.poll();
            if(currMin.get(2) < matrix.length-1){
                int row=currMin.get(1);
                int newCol=currMin.get(2)+1;
                pq.add(Arrays.asList(matrix[row][newCol],row,newCol));
            }
            count++;
        }
        return pq.peek().get(0);
    }
}
