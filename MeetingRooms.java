// Time Complexity : O(nlogn) sort the intervals based on the start time of the meeting
// Space Complexity : O(n) n is the minimum number of rooms required to conduct all the meetings which is the size of the queue 
// and in worst case it can reach the total number of intervals.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals ==  null || intervals.length == 0) return 0;
        
        //sort the given meeting intervals based on the start time of the meeting
        Arrays.sort(intervals, (a,b)-> (a[0] - b[0]));
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        queue.offer(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++){
            
            //check whether there are subsequent meetings so that it can be conducted in the same room hence we poll the element from the queue
            if(queue.peek() <= intervals[i][0]){
                queue.poll();
            }
            
            queue.offer(intervals[i][1]);
            
        }
        return queue.size();  //at the end size of the queue will determine how many minimum rooms are required to conduct the meeting
    }
}
