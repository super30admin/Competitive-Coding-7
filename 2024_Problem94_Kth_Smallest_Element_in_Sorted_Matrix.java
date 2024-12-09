//378. Kth Smallest Element in a Sorted Matrix - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
//Time Complexity: O(m*n*log(k))
//Space Complexity: O(k)


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //base case
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                pq.add(matrix[i][j]);

                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}