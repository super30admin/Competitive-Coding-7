// Time Complexity :O(min(k,n)+klogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    
    class Node{
  int row;
  int col;

  Node(int row, int col){
    this.row = row;
    this.col = col;
  }
}
    public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Node> minHeap = new PriorityQueue<>((n1,n2)->matrix[n1.row][n1.col]-matrix[n2.row][n2.col]);

   for(int i = 0;i<matrix.length && i<k;i++){
     minHeap.add(new Node(i,0));
   }
   int result = 0;
   while(!minHeap.isEmpty()){
    Node temp = minHeap.poll();
    result = matrix[temp.row][temp.col];
    k--;
    if(k==0){
      break;
    }   
    temp.col++;
    if(temp.col<matrix[0].length){
      minHeap.add(temp);
    }
   }

   return result; 
    }
}