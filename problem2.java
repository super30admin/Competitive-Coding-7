class Solution {
    public int findKthLargest(int[] nums, int k) {
        //min_heap
        //time-nlogK
        //space-O(k); to store heap elements of size k
        
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int len= nums.length;
        for(int n: nums){
            pq.add(n);
            if(pq.size() >k){
               pq.poll();
        }
        
    
        }
        return pq.peek();
        
    }
}