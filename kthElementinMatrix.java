// Tc: O(Nlog(max-min))
// SC: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while(left<right){
            int mid=left+(right-left)/2;
            int count = countLess(matrix,mid);
            if(count<k) left=mid+1;
            else right=mid;
        }
        return left;
    }

    private int countLess(int[][] matrix,int target){
        int count=0;
        int j=matrix.length-1;
        for(int i=0;i<matrix[0].length;i++){
            while(j>=0 && matrix[i][j]>target) j--;
            count +=j+1;
        }
        return count;
    }
}