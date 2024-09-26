// Time Complexity : O(min(K,N)+ Klog(min(K,N))
// Space Complexity : O(N)
//Leetcode problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));

        q.add(new int[]{0,0});

        for(int i=1;i<Math.min(n, k);i++){
            q.add(new int[]{i,0});
        }

        while(k > 1){

            int[] curr = q.poll();

            if(curr[1] < n-1){
                q.add(new int[]{curr[0], curr[1]+1});
            }

            k--;
        }

        int[] res = q.peek();
        return matrix[res[0]][res[1]];

    }
}