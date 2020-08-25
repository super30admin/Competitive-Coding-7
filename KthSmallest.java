/*

// Time Complexity : O(mnlog(n)) m = colums in matrix, n = rows in matrix
// Space Complexity :O(n) // n = rows in matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach

*/

class Solution {
    // create node to store row info
    class Node{
        int id;
        int indx;
        Node(int id, int indx){
            this.id = id;
            this.indx = indx;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // create min heap to store lowest value first
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2){
                return matrix[node1.id][node1.indx] - matrix[node2.id][node2.indx];
            }
        });

        // assign each row an id and strt indx
        for(int i = 0 ; i < matrix.length; i++){
            pq.offer(new Node(i, 0));
        }
        int ret = -1;

        // get kth smallest elem
        while(!pq.isEmpty() && k > 0){
            Node node = pq.poll();
            ret = matrix[node.id][node.indx];
            if(node.indx != matrix[node.id].length - 1){
                node.indx += 1;
                pq.offer(node);
            }
            k--;
        }
        return ret;
    }
}
