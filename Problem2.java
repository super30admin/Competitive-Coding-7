// Time Complexity : O(n log k) where k is the range i.e min value to max value in the array.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Approach : The idea to perform bnary search as the first element in matrix will be the min value and last one will be the max as they
// are sorted row wise and column wise. Once we find the mid is found, count the elements that are less than or equal to mid and move
// the search space based on it. To find the count, we start from top right as we have lesser and greater elements on both directions of it.
// We continue until low didn't meet high and return the low or high value to get the kth samllest.


class Solution {
    int n;
    public int kthSmallest(int[][] matrix, int k) {
        this.n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high){
            int mid = low + (high-low)/2;
            int count = countLessThanMid(matrix, mid); //to check the count of elements less than or equal lo mid
            if(count >= k){ //move the seach space to left
                high = mid;
            }else{
                low = mid+1;//move the seach space to right
            }
        }
        return low;
    }

    private int countLessThanMid(int[][] matrix, int target){
        //start counting from top right end
        int row = 0;
        int col = n-1;
        int count = 0;
        while(row < n && col >=0){
            if(matrix[row][col] <= target){
                count += col+1; //increase the count as that entire row will also be less than target
                row++;//move to next row
            } else{
                col--;//move backwards in the column
            }
        }
        return count;
    }
}
