class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new MyComp());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                        pq.poll();
                }
            }
        }
        return pq.poll();
    }
}

class MyComp implements Comparator<Integer>{
    public int compare(Integer i,Integer j){
        if(i<j) return 1;
        return -1;
    }
}
