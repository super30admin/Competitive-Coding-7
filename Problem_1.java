// Time Complexity : O(2n*log(maxVal))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take low as the first value and high as last value in the matrix, have the counterfunction to get the index of the mid value, if the count < k then l = m + 1 else h = m; in the count function, set i = n-1 and j = 0, if the value is less or equal the mid(which we find) then increase j and count by count + (i+1) else decrease i pointer, at the end, return count from that function. at the end return the high.
// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int l = matrix[0][0];
        int h = matrix[n-1][n-1];
        while(l < h){
            int m = l + (h-l) / 2;
            int count = getCount(matrix, n, m);
            if(count < k){
                l = m + 1;
            }else{
                h = m;
            }
        }
        return h;
    }
    private int getCount(int [][] matrix, int n, int m){
        int i = n-1;
        int j = 0;
        int count = 0;
        System.out.println("Start:"+m);
        while(j < n && i >= 0){
            if(matrix[i][j] <= m){
                j++;
                System.out.println(count);
                count = count + (i+1);
            }else{
                i--;
            }
        }
        System.out.println("Count"+count);
        System.out.println("End:"+m);
        return count;
    }
}