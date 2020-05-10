// Time Complexity : O(mn log(n))
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInAMatrix {
    class Node {
        int val;
        int r;
        int c;

        public Node(int val, int r, int c){
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return a.val - b.val;
            }
        });

        int m = matrix.length;
        int n = matrix[0].length;

        int counter = 0;
        int result = 0;

        for(int i = 0; i < m; i++){
            pq.add(new Node(matrix[i][0],i,0));
        }

        int r = 0;
        int c = 0;
        while(!pq.isEmpty() && counter < k){
            Node temp = pq.poll();
            result = temp.val;
            counter++;
            r = temp.r;
            c = temp.c + 1;
            if(r < m && c < n){
                pq.add(new Node(matrix[r][c], r, c));
            }
        }

        return result;
    }
}
