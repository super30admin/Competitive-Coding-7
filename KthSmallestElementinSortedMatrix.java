/*
 * Add all the elements in the max heap
 * Keep popping the elements from the heap until the size of the heap is not equals to k. As we are using max heap, popping until k will remove n-k elements greater than the kth element
 * Whatever is at the top of the heap is the kth smallest
 * TC: O(n^2logn) -> iterate through the matrix n^2 and insertion to heap of all elements O(logn^2)-> O(logn) and removal is also logk so total is O(n^2logn)
 * SC: O(n^2) -> n*n elements in the heap
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pq.add(matrix[i][j]);
            }
        }
        while(pq.size() != k){
            pq.poll();
        }
        return pq.peek();
    }
}
