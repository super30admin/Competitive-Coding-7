//Using minHeap
//TC:O(NlogN)
//SC:O(N)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        
       // Sort based on start time 
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
       // Maintain a minHeap that stores the end time 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        
        // Add the first meeting
        minHeap.add(intervals[0][1]);
        
         // Iterate over remaining intervals
        for ( int i = 1; i < intervals.length; i++){
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= minHeap.peek()){
                minHeap.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            minHeap.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return minHeap.size();
    }
}
