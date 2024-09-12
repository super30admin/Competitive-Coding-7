class Solution {
    public int kthSmallest(int[][] matrix, int k) {
          if(matrix == null) return -1;

        //get low and high number in the matrix 
        //i.e. 1st and last respectively
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];

        //binary search for getting k -> 1st k elements 
        while(low < high){
            int mid = low + (high - low) /2;

            //get number of elements less than middle
            int count = getCount(matrix, mid);

            //adjust the space based on how many numbers are before middle element
            if(count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int getCount(int[][] matrix, int mid){
        int count = 0;
        int col = matrix.length - 1;
        for(int row = 0; row < matrix.length; row++){
            while(col >= 0 && matrix[row][col] > mid)
                col--;

            //found correct element, add those many to the count
            count += (col+1);
        }
        return count;

    }
}
        
    
