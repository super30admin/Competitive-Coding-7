/*
Time complexity: O((M*N)logk) where M*N is total elements in to 2d matrix in row and col wise sorted matrix.
and k is the max size of heap at any given point of time
Space complexity: O(M*N) would be inserting all the elememts of the matrix 
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int row = matrix.length;
       int col = matrix[0].length;
        
        //creating max heap as I want to find smallest element so I want to get rid of larger elements and 
        //max heap would give me access to larger elemenets
       PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> b-a);
        
       for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                //adding matrix elements in the maxheap
                pq.add(matrix[i][j]);
                //if heap size goes beyond k I would be removing the larger elemenet from the top of the queue.
                if(pq.size() > k) pq.remove();
            }
       }
        //after that at the end top element in the queue would be kth smallest element
       return pq.peek();
    }
}


