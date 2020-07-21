executed in leetcode- failing for some cases
Time complexity-klogk;

class Solution {
    public class Node{
       public int r,c;
       public int val;
       public Node(int r, int c, int val){
           this.r=r;
           this.c=c;
           this.val=val;
       }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0) return -1;
        if(matrix.length==1 && k==1) return matrix[0][0];
        PriorityQueue<Node> q= new PriorityQueue<Node>((a,b)->{
            if(a.val!=b.val)return a.val-b.val;
            else return b.c-a.c;
                });
        for(int i=0;i<matrix.length;i++){
         q.add(new Node(i,0,matrix[i][0]));
        }
        while(k>0){
           Node node = q.poll();
            k--;
           if(k==0) return node.val;
           if(node.c==matrix.length-1) {
               node=q.poll();
               k--;
           }
           if(k==0) return node.val;
           Node nxtNode = new Node(node.r,node.c+1,matrix[node.r][node.c+1]);
           q.add(nxtNode);
        }
        return q.poll().val;
    }
}
