// Time Complexity :m*nlogm
// Space Complexity :logm*n
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       // base case 
        if(matrix==null || matrix.length==0) return 0;
        Comparator<Pair> customComparator = new Comparator<>(){
        public int compare(Pair a  , Pair b){
            return a.val-b.val;
        }
            };
        PriorityQueue<Pair> minheap = new PriorityQueue(customComparator);
        
        int row = matrix.length;
        int col = matrix[0].length; 
        for(int i=0;i<row;i++){
            // minheap.add(matrix[i][0]);
            minheap.add(new Pair(i,0,matrix[i][0]));
        }
        
       while(k>1){
           Pair current = minheap.poll();
           k--;
           if(current.j+1<col){
               int r = current.i;
               int c = current.j+1;
               Pair next = new Pair(r,c,matrix[r][c]);
               minheap.add(next);
           }
       }
        return minheap.poll().val;
           
    }
}
class Pair{
    int i;
    int j;
    int val;
    Pair(int i,int j,int val){
        this.i=i;
        this.j=j;
        this.val=val;
    }
}