import java.util.PriorityQueue;

// Time Complexity : 
/* Approach 1: Using Max heap  : O(n) where n is the number of elements in the matrix
   Approach 2: Using Binary Search: (mn log(mn)) where m is the number of rows and n is the number of columns
// Space Complexity : 
    Approach 1: Using Max heap  : O(k) where k is the number of elements in the Priority Queue
   Approach 2: Using Binary Search: O(1) 

*/

// APPROACH 1: USING MAX HEAP
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     if(matrix == null || matrix.length == 0){return 0;}
     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);                                       
     for(int i = 0; i < matrix.length; i++)
     {for(int j = 0; j < matrix[0].length; j++){
         pq.add(matrix[i][j]);                                                                          
         if(pq.size() > k){
             pq.remove();                                                                          
         }
     }
     }
       return pq.peek();                                                                                
    }
}

// APPROACH 2: USING BINARY SEARCH
public class KSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){return 0;}
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int low = matrix[0][0], high = matrix[m-1][n-1];                                 
        while(low < high){
            int mid = low + (high-low)/2;                                                   
            count = 0;
            int j = n-1;
            for(int i =0; i < m; i++){
                while(j >=0 && matrix[i][j] > mid){                                         
                    j--;
                }
                count+=j+1;                                                                 
            }
            if(count < k){
                low = mid+1;                                                             
            } else {
                high = mid;                                                                 
            }
        }
       return low;
    }
} 