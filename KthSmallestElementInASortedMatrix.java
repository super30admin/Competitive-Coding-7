// Time Complexity : O(nlogk)
// Space Complexity : O(k) k is the size of the heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0)    return 0;
        
        //create a maxheap so that our kth smallest element will be on the top
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        
        for(int row[]: matrix){
            for(int element: row){
                queue.offer(element);
                
                if(queue.size() > k){ //kth smallest element will remain on the top and if size of queue exceeds k, we poll the element
                    queue.poll();
                }
            }
        }
        
        return queue.poll();
    }
}
