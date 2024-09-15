 // time complexity: o(mnlogmn)
 // space complexity : o(1)
 // did it run on leetcode : yes
 // any doubt : no
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //first elemennt in 2d matrix
        int low=matrix[0][0];
        //last element 
        int high=matrix[n-1][n-1];
        while(low < high){
            int mid = low + (high-low)/2;
            int counter = count(matrix,mid);
            if(counter < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    
    public int count(int matrix[][], int mid){
        //start from last column
        int j=matrix.length-1;
        int count = 0;
        //for each row how many elements are greater than mid
        for(int i=0;i<matrix.length;i++){
            //if element is greater go to before column
            while(j>=0 && matrix[i][j] > mid){
                j--;
            }
        //increment the count by those many columns +1(as column starts from 0) as those many elements are less than mid
            count += j+1;
        }
       return count; 
    }
}