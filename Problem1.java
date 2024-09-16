// Time Complexity : O(mxnxlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//378. Kth Smallest Element in a Sorted Matrix
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    //Brute Force
    //time: O(mxnxlogk)
    //space: O(k)
    public int kthSmallest(int[][] matrix, int k) {
       
        int count = 0;
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                pq.add(matrix[i][j]);
                
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}