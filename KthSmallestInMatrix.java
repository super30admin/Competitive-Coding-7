/*

Passed All Test Cases 

MaxHeap approach 

Big O
Time-> O(MNLogK), where M i # of rows, N is # of columns, and K is the Kth given in the q
Space ->O(P), where P is the total No of elements in the matrix, i.e. rows * columns 

*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //making maxHeap of size k 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder()) ;
        
        //adding elements to maxHeap 
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix.length ; j++) {
                if(maxHeap.size() < k) {
                    maxHeap.add(matrix[i][j]) ; 
                } else if (matrix[i][j] <= maxHeap.peek()) {
                    maxHeap.remove() ; 
                    maxHeap.add(matrix[i][j]) ; 
                }
            }
        }
        return maxHeap.remove() ; 
    }
}

/*

Binary Search 

Big O
Time -> O(N* log(max - min)), N is # of elements in Matrix, and min is Matrix[0][0] and Max is Matrix[matrix.length - 1][Matrix.length - 1]
Space -> O(1)
*/


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length ; 
        int left = matrix[0][0] ; 
        int right = matrix[n - 1][n - 1] ; 
        
        while (left < right) {
            int mid = left + (right - left) / 2  ; 
            int count = getCount(matrix, mid) ; 
            if (count < k) left = mid + 1 ; 
            else
                right = mid ; 
        }
        
        return left ; 
    }
    
    private int getCount(int matrix[][], int mid) {
        int count = 0 ; 
        int j = matrix.length - 1 ; 
        for (int i = 0 ; i < matrix.length ; i++) {
            while(j >= 0 && matrix[i][j] > mid) 
                j-- ; 
            count += j + 1 ; 
        }
        
        return count ; 
    }
}