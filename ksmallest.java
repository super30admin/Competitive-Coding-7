class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int n=matrix.length;
        int high=matrix[n-1][n-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=getCount(mid,matrix,n);
            if(count<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    private int getCount(int mid,int[][]matrix, int n){
        int j=n-1;
        int count=0;
        for(int i=0;i<n;i++){
            while(j>=0 && matrix[i][j]>mid) j--;
            count+=j+1;
        }
        return count;
    }
}
