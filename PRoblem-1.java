//Time Complexity : O(nlogk)
//Space Complexity : O(k)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        
        for(int i =0; i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if(heap.size() >= k && heap.peek() > matrix[i][j]){
                    heap.poll();
                    heap.add(matrix[i][j]);
                }
                else if(heap.size() < k) {
                    heap.add(matrix[i][j]);
                }
            }
        }
        return heap.poll();
    }
}