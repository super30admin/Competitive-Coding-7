//Leetcode: 378. Kth Smallest Element in a Sorted Matrix
//Time complexity: O(nlogk) // where n is the number of elements in the matrix and k is the size of heap
//Space Complexity: O(k) // k is the size of the heap
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null   || matrix.length==0 || matrix[0].length==0) return -1;
        
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->(b-a));
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }       
        return pq.poll();
        
        
    }
}