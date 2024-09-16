//Time : O(N) * O(N log N)
//Space: O(N)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        //int m = matrix.length; int n = matrix[0].length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (b - a));
        for(int i=0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                q.add(matrix[i][j]);
                if(q.size()>k){
                   q.poll();
                }
            }
        }
        int ans = q.poll();
        return ans;
    }
}