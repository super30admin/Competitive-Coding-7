//Approach - Binary Search - the search space is reduced with the help of a binary search
//        a mid value is taken and the count of elements that are lesser than mid value is counted
//        if the count == k, then we have reached the kth smallest element
//        or the start and end value is adjusted and the process is repeated till start < end
//Time Complexity - O(Nlog(max-min))
//Space Complexity - O(1)
class Solution {
  public int kthSmallest(int[][] matrix, int k) {

    int n = matrix.length;
    int start = matrix[0][0];
    int end = matrix[n-1][n-1];

    while(start < end){
      int mid = start + (end-start)/2;

      int[] lowHighPair = new int[]{matrix[0][0], matrix[n-1][n-1]};

      int count = binarySearch(matrix, mid, lowHighPair);

      if(count == k){
        return lowHighPair[0];
      }
      else if(count < k){
        start = lowHighPair[1];
      }
      else{
        end = lowHighPair[0];
      }
    }
    return start;
  }

  private int binarySearch(int[][] matrix, int mid, int[] lowHighPair){
    int count=0;
    int n=matrix.length, row=n-1, col=0;

    while(row >= 0 && col < n){

      if(matrix[row][col] > mid){
        lowHighPair[1] = Math.min(lowHighPair[1], matrix[row][col]);
        row--;
      }
      else{
        count = count+row+1;
        lowHighPair[0] = Math.max(lowHighPair[0], matrix[row][col]);
        col++;
      }
    }

    return count;
  }
}
