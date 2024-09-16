class KthSmallestElementInSortedMatrix {
    
    // Time Complexity: O(klogk)    (where k = mn in the worst case)
    // Space Complexity: O(k)
    
    public int kthSmallest(int[][] matrix, int k) {
        // Edge Case Checking
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0)
            return -1;
        
        int n = matrix.length;
        int m = matrix[0].length;
        // Creating a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Traverse through the matrix and add elements to the heap
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxHeap.add(matrix[i][j]);
                // If the heap size goes greater than k - remove the root element
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        // After the traversal - the root element will be the kth smallest element
        return maxHeap.peek();
    }
}