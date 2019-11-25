//Time Complexity :O(K*Log(row)).
//Space Complexity :O(row).
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope.


//Your code here along with comments explaining your approach

class KSmallestInASortedMatrix {
    class Pair implements Comparable<Pair>{
        int row, col, val;
        public Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        public int compareTo(Pair other){
            return this.val - other.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(null == matrix || 0 == matrix.length){return Integer.MIN_VALUE;}
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int j = 0; j < matrix.length; j++){
            pq.add(new Pair(j,0,matrix[j][0]));
        }
        for(int i = 0; i < k - 1; i++){
            //System.out.println(pq.size()+" "+pq.peek().val);
            Pair p = pq.poll();
            if(p.col+1 == matrix[0].length){continue;}
            pq.add(new Pair(p.row,p.col+1,matrix[p.row][p.col+1]));
        }
        return pq.peek().val;
    }
}