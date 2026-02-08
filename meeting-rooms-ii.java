// TimeComplexity: O(nlogn)
// SpaceComplexity: O(n)
// Explanation: First, I sort the meetings by start time. I use a min-heap to store the end times of ongoing meetings.
//  For each new meeting, if its start time is before the earliest ending meeting, I allocate a new room; otherwise, 
// I reuse a room by removing the finished meeting from the heap. The maximum size of the heap at the end gives the minimum number of rooms required.
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sorting based on the 1st index
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        
        for(int i =1; i< intervals.length; i++) {
            int currStart = intervals[i][0];
            if(!pq.isEmpty()){
                if(currStart < pq.peek()) {
                pq.add(intervals[i][1]);
                } else{
                    pq.poll();
                    pq.add(intervals[i][1]);
                }
            }   
        }
        return pq.size();
    }
}