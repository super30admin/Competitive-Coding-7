class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        
        int l = matrix[0][0];
        int r = matrix[n-1][n-1];
        
        while(l<r){
            int mid = l+(r-l)/2;
            
            int count = countNums(matrix,mid);
            if(count<k) l = mid+1;
            else r=mid;
        }
        
        return l;
        
    }
    
    public int countNums(int[][] matrix, int mid){
        int count=0;
        int j = matrix.length-1;
        
        for(int i=0;i<matrix.length;i++){
            while(j>=0 && matrix[i][j]>mid) j--;
            count += j+1;
        }
        
        return count;
    }
}