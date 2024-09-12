/**
 * Time: O(K) k - input k max can be matrix.length
 * Space: O(n) n-matrix.length
 *  I chose this value because while choosing any kth smallest value, we need max diagonal elements which was equal to row or col length
 *  so whnever the ele is removed the next contender will be the next ele (as its sorted)
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int cnt = 0;

        cnt = Math.min(k,matrix.length);
        for(int i=0;i<matrix.length;i++)
            pq.offer(new Integer[]{matrix[0][i],0,i});            //Input all the first row or first col elements

        while(!pq.isEmpty()){
            k--;
            Integer[] retval = pq.poll();
            if(k == 0)
                return retval[0];
            if(retval[1] != matrix.length-1)
                pq.offer(new Integer[]{matrix[retval[1]+1][retval[2]],retval[1]+1,retval[2]});
        }
        return 99999;
    }
}

/**
 * Time: O(nlog m) m- max ele - min ele in the matrix and n - total ele in the matrix
 * Space: O(1)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length-1][matrix.length-1];
        int[] pair = new int[2];
        int cnt = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            pair[0] = matrix[0][0];
            pair[1] = matrix[matrix.length-1][matrix.length-1];
            cnt = chk(matrix,pair,mid);
            if(cnt == k) return pair[0];

            if(cnt < k) low = pair[1];
            else high = pair[0];
        }
        return low;
    }
    private int chk(int[][] matrix, int[] pair, int mid){
        int cnt = 0;
        for(int i=0;i<=matrix.length-1;i++){
            for(int j=0;j<=matrix.length-1;j++){
                if(matrix[i][j] <= mid){
                    cnt++;
                    pair[0] = Math.max(pair[0],matrix[i][j]);
                }else{
                    pair[1] = Math.min(pair[1],matrix[i][j]);
                }
            }
        }
        return cnt;
    }
}