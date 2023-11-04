// Time Complexity:  O(n*logk)
// Space Complexity: O(k)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(maxHeap.size() < k) {
                    maxHeap.add(matrix[i][j]);    
                }
                else {
                    if(maxHeap.peek() > matrix[i][j]) {
                        maxHeap.add(matrix[i][j]);
                        maxHeap.remove();   
                    }
                }
            }
        }
        return maxHeap.peek();
    }
}

// // ******************** Another Method ********************
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
//         for(int i=0; i<matrix.length; i++) {
//             for(int j=0; j<matrix[0].length; j++) {
//                 maxHeap.add(matrix[i][j]);
//                 if(maxHeap.size() > k) {
//                     maxHeap.remove();
//                 }
//             }
//         }
//         return maxHeap.poll();
//     }
// }
