/* Time complexity: O(logn)
space complexity: O(1)
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        if(k == 0) return 0;
        //int count = 0;
        
        int low = matrix[0][0]; int high = matrix[matrix.length-1][matrix[0].length-1];
       
        
        while(low < high){ 
            int mid = low + (high-low)/2;
            //int count = 0;
            int getCount = gettcount(matrix, mid);
            if(getCount<k) low = mid+1;
            else high = mid;
        }
        return low;
    }
    
    public int gettcount(int[][]matrix, int mid){
        int count = 0;
        int length = matrix.length-1;
        int j = length;
        for(int i=0; i<=length; i++){
            while(j>=0 && matrix[i][j]>mid){
                j--;
                count += j+1;
            }
        }
        return count;
    }
}
            
                    
               