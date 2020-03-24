class Solution {
    int row , col;
    public int kthSmallest(int[][] matrix, int k) {
        row = matrix.length;
        col = matrix[0].length;
        //return kthSmallestUsingHeap(matrix, k);
        return kthSmallestUsingBinarySearch(matrix, k);
    }
    /*
    Time complexity: (M*N)O(logK) heap of size k, m is number of rows and n is number of column.
    Space complexity: O(M*N)
    */
    private int kthSmallestUsingHeap(int[][] matrix, int k){
        //creating max heap as I want to find smallest element so I want to get rid of larger elements and 
        //max heap would give me access to larger elemenets
       PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> b-a); 
       for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k) pq.remove();
            }
       }
       return pq.peek();
    }
    /*
    Time complexity: (M+N)O(logN) heap of size k, m is number of rows and n is number of column.
    Space complexity:O(1)
    */
    private int kthSmallestUsingBinarySearch(int[][] matrix, int k){
        int low = matrix[0][0], high = matrix[row-1][col-1];
        int mid =0;
        while(low <= high){
            mid = low+ (high-low)/2;
            int count = getCountOfSmallerNumber(matrix, mid);
            //I have count number of elements less than or equal to mid; 
            //so if my count is less than k, my kth smallest would be lie on the right side
            if(count < k) low = mid+1;
            //else it wouls lie on the left side.
            else high= mid-1;
        }
        return low;
    }
    private int getCountOfSmallerNumber(int[][] matrix, int n){
        //
        int i= row-1, j=0;
        int count=0;
        /*intution here is that, I would be starting from lower left corner, if element at that cell is less than or equal to n then all the element in that row
        would be smaller than this number so we can just increment total count by row index (total number in that row) and increment the column. 
        else if elemenet is greater than number then just decrement the row index because i might find smaller elements in the upper rows.
        */
        while(i>=0 && j<col){
            if(matrix[i][j] <= n){
                count+= i+1;
                j++;
            }
            else i--;
        }
        return count;
    }
}


