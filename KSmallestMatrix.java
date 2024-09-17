// Time Complexity : 
/* Approach 1: Using Max heap  : O(n) where n is the number of elements in the matrix
   Approach 2: Using Binary Search: (mn log(mn)) where m is the number of rows and n is the number of columns
// Space Complexity : 
    Approach 1: Using Max heap  : O(k) where k is the number of elements in the Priority Queue
   Approach 2: Using Binary Search: O(1) Iterative
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with the binary search approach
/* Your code here along with comments explaining your approach: In approach 1, for each of the elements faced, put it in the priority queue/ max heap
If the queue size exceeds the k capacity, remove it from the queue. Return the top element of the queue as the kth smallest element. In approach 2,
use binary search to reach the mid, count the number of elments lesser than the mid, if the count < k, move to the right search space else move to the
left search space.
*/

// APPROACH 1: USING MAX HEAP
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     if(matrix == null || matrix.length == 0){return 0;}
     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);                                       // Max Heap 
     for(int i = 0; i < matrix.length; i++)
     {for(int j = 0; j < matrix[0].length; j++){
         pq.add(matrix[i][j]);                                                                          // Add the elements into Max Heap
         if(pq.size() > k){
             pq.remove();                                                                               // Remove from the queue the max element once it gets full
         }
     }
     }
       return pq.peek();                                                                                // Return the kth smallest elements
    }
}

// APPROACH 2: USING BINARY SEARCH
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){return 0;}
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int low = matrix[0][0], high = matrix[m-1][n-1];                                    // Assign low and high elements
        while(low < high){
            int mid = low + (high-low)/2;                                                   // Get the mid
            count = 0;
            int j = n-1;
            for(int i =0; i < m; i++){
                while(j >=0 && matrix[i][j] > mid){                                         // while the elements are greater than mid, ignore
                    j--;
                }
                count+=j+1;                                                                 // else count the number of elements < mid
            }
            if(count < k){
                low = mid+1;                                                                // move to the right search space
            } else {
                high = mid;                                                                 // move to the left search space
            }
        }
       return low;
    }
} 