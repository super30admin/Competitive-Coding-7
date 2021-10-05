// Time Complexity - O(Nlog(Max-Min)) where N is the row of matrix and Max and Min are the values in the matrix
// Space Complexity - O(1)

class Solution {
    int currMin;
    int currMax;
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        
        while(low<high){
            int mid = low + (high-low)/2;
            int nums = numberOfSmallestElementThenMid(mid, matrix);
            if(nums == k){
                return currMin;
            }
            else if(nums < k){
                low = currMax;
            }
            else{
                high = currMin;
            }
            
        }
        return low;
    }
    
    private int numberOfSmallestElementThenMid(int mid, int[][] matrix){
        int nums = 0;
        int i = matrix.length-1;
        int j = 0;
        currMin = matrix[0][0];
        currMax = matrix[matrix.length-1][matrix[0].length-1];
        
        while(i>=0 && j<matrix[0].length){
            if(matrix[i][j] <= mid){
                currMin = Math.max(currMin, matrix[i][j]);
                j++; 
                nums
            }
            else {
                currMax = Math.min(currMax, matrix[i][j]);
                i--;
                nums += j;
            }
        }
        
        if(j>=matrix[0].length){
            nums += (i+1)*matrix[0].length;
        }
        
        return nums;
    }
}