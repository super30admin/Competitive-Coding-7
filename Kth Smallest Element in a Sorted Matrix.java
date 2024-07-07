// Brute Force Solution
// Time Complexity = O(m*n)
// Space Complexity = O(k)

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
//         int n = matrix.length;
//         int m = matrix[0].length;        
//         for(int i = 0; i < n ; i ++){
//             for (int j = 0; j < m ; j++){
//                 if (n == 1 && m == 1 ) return matrix[i][j];
//                 pq.add(matrix[i][j]);
//                 if(pq.size() > k){
//                     pq.poll();
//                 }
                
//             }
//         }
//         return pq.peek();
//     }
// }

// Binary Search
// Time Complexity = O(n^2)
// Space Complexity = O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low < high){
            int count = 0;
            int mid = low + (high - low)/2;
            
            for(int i = 0; i< n; i ++){
                for(int j = 0; j<n; j++){
                    if(matrix[i][j] <= mid){
                        count++;
                    }
                }
            }
            
            if (count < k){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low;   
    }
}