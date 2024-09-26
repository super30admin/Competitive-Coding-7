//Time Complexity:O(n+logn)
//Space Complexity:O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n =matrix.length-1;
        int low=matrix[0][0];
        int high=matrix[n][n];
        while(low<high){
            int pivot=low+(high-low)/2;
            if(getCount(matrix,pivot)<k){
                low=pivot+1;
            }else{
                high=pivot;
            }
        }
        return high;
    }
    private int getCount(int[][] matrix, int piv){
        
        int n =matrix.length;
        //row will be first row
        int r= 0;
        //last coloumn
        int c=n-1;
        int count=0;
        while(r<=n-1 && c>=0){
            if(matrix[r][c]<=piv){
                count =count+c+1;
                r++;
            }
            else c--;
        }
        return count;
    }
}