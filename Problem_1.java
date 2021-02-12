// Time Complexity :O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(a-b));
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(pq.size()>=(matrix.length*matrix[0].length-k+1)){
                    pq.poll();
                }
                 pq.add(matrix[i][j]);
            }
        }
        
        //System.out.println(pq);
        return pq.peek();
    }
}