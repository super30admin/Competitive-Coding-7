// Time Complexity : O(n^2*log(n^2) + k*log(n^2)) where n is the dimension of matrix
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Add all the elements from the matrix to Priority Queue or min heap
//Pop k elements form the matrix and the kth element would be the answer
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));
        int n = matrix.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(count > k){
                    pq.add(matrix[i][j]);
                    pq.poll();
                }
                else{
                    pq.add(matrix[i][j]);
                }
            }
        }
        int res = -1;
        for(int i = 0; i < k; i++){
            res = pq.poll();
        }
        return res;
    }
}