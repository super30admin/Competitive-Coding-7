//Time = O(nlogn)
//space = O(n)

class Solution {
    class Triplet{
        int val;
        int row;
        int col;
        
        public Triplet(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int count=0;
        PriorityQueue<Triplet> p = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(int i=0;i<matrix.length;i++){
            p.add(new Triplet(matrix[i][0], i, 0));
        }
        
        while(!p.isEmpty()){
           Triplet t = p.poll();
            count++;
            if(count==k)
                return t.val;
            int nr = t.row;
            int nc = t.col + 1;
            if(nr<matrix.length && nc<matrix[0].length){
               p.add(new Triplet(matrix[nr][nc],nr,nc));
            }  
        }
        
        return -1;
        
    }
}

