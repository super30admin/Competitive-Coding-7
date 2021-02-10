class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        //add first row into the priority queue
        for(int i=0;i<matrix[0].length;i++)
            pq.add(new Node(0,i, matrix[0][i]));
        
        for(int i=0;i<k-1;i++){
            Node e = pq.poll();
            if (e.row+1 < matrix.length)
                pq.add(new Node(e.row+1, e.col, matrix[e.row+1][e.col]));    
        }
        
        return pq.peek().val;
    }
    
     public class Node implements Comparable<Node>{
        int row,col,val;
        
        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node e){
            return this.val - e.val;
        }
    }
    
}

//Time complexity : O(klogx) where x is min(n,k) n is the number of rows/columns in matrix
//Space complexity : O(x) for priorityqueue

