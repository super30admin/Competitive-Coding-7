// Min heap solution
class Solution {
   //Time Complexity:O(N^2logN)
   //Space Complexity:O(N)
    public int kthSmallest(int[][] matrix, int k) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int rem = 0;
    int col =0;
        while (k != 0 && col < matrix[0].length){
            for (int i =0;i < matrix.length;i++){
                pq.offer(matrix[i][col]);
            }
            col++;
            rem = pq.poll();
            k--;
            if (col == matrix[0].length){
                while (k!= 0){
             rem = pq.poll();
            k--;
                }
            }
        }
        return rem;
    }
}

// Binary Search Solution
//
class Solution {
    //Time Complexity: O(N log n)
    //Space Complexity: O(1)
    public int kthSmallest(int[][] matrix, int k) {
       //lets implement binary search
       //the idea is to check between the minimum and maximum numbers present in the array
       //rather than the indexes of the array
       //that's nifty

       int min = matrix[0][0], max = matrix[matrix.length-1][matrix[0].length-1];

       while (min != max){
        int mid = min + (max-min)/2;
        //check the number of elements less than mid
        int count = findCount (matrix, mid,k );
        if (count < k){
            min = mid+1;
        } else {
           max = mid;
        }
       } 
       return min;
    }

    private int findCount (int[][] matrix, int mid, int k){
            int count = 0;
            int n = 0, m = 0;
                for (int i = 0; i < matrix.length;i++){
                for (int j = 0; j < matrix[0].length;j++){
                   if (matrix[i][j] <= mid)
                   count++;
                   else
                   break; 
                }
            }
   return count;
}
}
