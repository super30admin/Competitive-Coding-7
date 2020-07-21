//Time Complexity: O(N * log(max - min)) 
//Space Complexity: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0 ) return 0;
        int l = matrix[0][0];
        int h = matrix[matrix.length-1][matrix[0].length-1];
        while(l < h) {
            int mid = l + (h - l) / 2;
            if (count(matrix,mid) < k)
                l = mid + 1;
            else
                h = mid;
        }
        return l;
    }
    
    private int count (int[][] matrix, int mid ) {
        int count = 0 ;
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if (matrix[i][j] <= mid){
                count += (j+1);
                i++;
            }
            else
                j--;
        }
        return count;
    }
}
