// Time Complexity : O(nlogn)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        // use min heap
        // Add (0,0) element
        // poll() and add row+1 and col+1 elemnt of polled elemnt
        // k-- for each poll
        // when k becomes 0 polled val is ans
        
        Set<Pair<Integer,Integer>> vis = new HashSet();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((Node a,Node b)->a.val-b.val);
        minHeap.add(new Node(0,0,matrix[0][0]));
        vis.add(new Pair(0,0));
        int ans = 0;
        int n = matrix.length;
        
        while(k>0) {
            
            Node min = minHeap.poll();
            ans = min.val;
            
            if(min.r<n-1 && !vis.contains(new Pair(min.r+1,min.c))) {
                minHeap.add(new Node(min.r+1,min.c,matrix[min.r+1][min.c]));
                vis.add(new Pair(min.r+1,min.c));
            }
            if(min.c<n-1 && !vis.contains(new Pair(min.r,min.c+1))) {
                minHeap.add(new Node(min.r,min.c+1,matrix[min.r][min.c+1]));
                vis.add(new Pair(min.r,min.c+1));
            }
            
            k--;
            
        }
        
        return ans;
    }
    
    public class Node {
        public int r;
        public int c;
        public int val;
        public Node(int r,int c,int val) {
            this.r=r;
            this.c=c;
            this.val=val;
        }


    }
}

