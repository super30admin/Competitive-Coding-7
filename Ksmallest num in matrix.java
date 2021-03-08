//Time complexity-O(logn)
//Space Complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     int low = matrix[0][0];
     int high = matrix[matrix.length-1][matrix.length-1];
     while(low<high) {//finding all the elements less than mid , here mid is calculated on values not index
         int mid = (low +high)/2;
         int count= helper(matrix,mid);
         if(count<k)
            low=mid+1;
         else
             high = mid;
         }
     return low;
    }
    
     public int helper(int[][] arr, int mid){
     int count=0;
     int j=arr.length-1;
     for(int i=0;i<arr.length;i++) {
             while(j>=0 && arr[i][j]>mid)
             j--;
             count+=j+1;
     }
     return count;
 }
    
}