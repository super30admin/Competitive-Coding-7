
// Time Complexity : X = MIN(N,K) ; TC = X + O(KlogX)
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Node{
    int x,y,val;
    public Node(int x,int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++){
            pq.add(new Node(i,0,matrix[i][0]));
        }
        for(int i = 0 ; i < k-1 ; i++){
            Node temp = pq.poll();
            if(temp.y < n-1) pq.add(new Node(temp.x,temp.y+1,matrix[temp.x][temp.y+1]));
        }
        return pq.poll().val;
    }
}
