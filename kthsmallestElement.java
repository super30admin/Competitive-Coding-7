// Time Complexity : O(nlog(max-min)) - where n is the number of elements and we perfom the binary search between the max and min values so it is the log(max-min)
// Space Complexity-O(1)- no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Perfom a binary search bu using the max and min elements as the limits. Get the count of all the elemets lesser than the mid if the elements is less than k increase the low ponter to mid+1, or else decrease the nigh pointer to mid. At a point where high and low are equal return either. This is the kth smallest element.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      int low=matrix[0][0];
      int high=matrix[matrix.length-1][matrix.length-1];
      while(low<high){
          int mid=low+(high-low)/2;
          int c=countValue(matrix,mid);
          if(c<k){
              low=mid+1;
          }
          else 
              high=mid;
      }
        return low;
      
    }
    public int countValue(int[][] matrix, int mid){
        int result=0;
        int j=matrix.length-1;
        for(int i=0;i<matrix.length;i++){
            while(j>=0 && matrix[i][j]>mid) j--;
            result+=j+1;
        }
        return result;
}   
}