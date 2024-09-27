//TC: O(log (n))
//SC: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; int high = matrix[n - 1][n - 1];
        
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);
            if(count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
    private int getCount(int[][] arr, int x){
        int j = arr.length - 1;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            while(j >= 0 && arr[i][j] > x) j--;
            count += j + 1;
        }
        return count;
    }
}
