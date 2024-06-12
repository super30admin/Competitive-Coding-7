class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        
        //limiting the size of max heap to k 
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }
        // after adding all the elements in heap, the top element in heap of size k is Kth smallest element
        return maxHeap.poll();
    }
}
// Time Complexity: O(n*n)
// Space Complexity: O(k)