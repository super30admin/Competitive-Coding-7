// Time Complexity : O(nlogn) - (for sorting) nlogn for sorting, where logk is the heapify for maximum complexity when  all the n elements are in thw queue. Ans a total of n elements.(nlogn takes the precedence)
// Space Complexity : O(n) - where n is the number of elements in intervals.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Thea approach is to always first sort all the values. So, then we always add the last time interval when a meeting is ended to the queue after we compare the min in the priority queue with when the meeting has to start. If there is a clash then we need a new meeting room. If not, we can remove the min and add the time the new meeting will finish into the queue.


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            int peekVal=pq.peek();
            if(peekVal<=intervals[i][0]){
                pq.remove();
            }
             pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}