//time o(N(log(Max-min))
//space o(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length ==0)
            return 0;
        
        int len = matrix.length;
        
        int low =matrix[0][0], high = matrix[len-1][len-1];
        
        while(low < high) {
            int mid = low + (high-low)/2;
            int[] bigSmall = {matrix[0][0],matrix[len-1][len-1]};
            //no of elements in left half
            int count = calElementsLM(matrix, mid, bigSmall);
            if(count == k) {
                return bigSmall[0];
            }
            else if(count > k) {
                high = bigSmall[0];
            }
            else {
                low = bigSmall[1];
            }
        }
        return low;
    }
    
    private int calElementsLM(int[][] matrix, int mid, int[] bigSmall) {
        int r = matrix.length-1, c = 0;
        int count =0;
        while(r>=0 && c<matrix.length) {
            if(matrix[r][c] > mid) {
                bigSmall[1] = Math.min(matrix[r][c], bigSmall[1]);
                r--;
            }
            else {
                bigSmall[0] = Math.max(matrix[r][c], bigSmall[0]);
                count = count + r +1;
                c++;
            }
        }
        return count;
    }
}