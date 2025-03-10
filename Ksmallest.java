
// Time Complexity : O(Min(m,k)+klogMin(m,k))
// Space Complexity : O(Min(m,k))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
PriorityQueue
 */

class Solution {

    class Node {
        int val;
        int r;
        int c;

        Node(int val,int r,int c){
            this.val=val;
            this.r=r;
            this.c=c;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i=0;i<matrix.length;i++){
            pq.add(new Node(matrix[i][0],i,0));
        }

        while(--k>0){
            Node n=pq.poll();
            int r=n.r;
            int c=n.c;
            if(c<matrix[0].length-1){
                pq.add(new Node(matrix[r][c+1],r,c+1));
            }
        }

        return pq.poll().val;
    }
}
