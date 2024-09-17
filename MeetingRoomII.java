// Time Complexity : O(n log n) + O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//sort the intervals according to start time
//maintain priority queue, min heap of the next immediately avaiable meeting room time
//iterate over meetings to check heap top end time <= cur meeting start time, if yes poll() and add()
// else just add
// return heap.size() as the number of meeting rooms

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        
        Arrays.sort(intervals, (int[] m1, int[] m2) -> m1[0] - m2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int[] m : intervals){
            if(pq.size()>0 && pq.peek()<=m[0]){
                pq.poll();
            }
            pq.add(m[1]);
        }
        
        return pq.size();
    }
}