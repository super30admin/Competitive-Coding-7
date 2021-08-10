// Time Complexity : o(nlogK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
       

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