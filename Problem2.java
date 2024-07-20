/*
    LC - 253. Meeting Rooms II
    TC - O(N log N)
    SC - O(N)
    Approach
        Using min heap
        Sort the intervals based on the start time
        Traverse the intervals
        poll until pq is empty and the pq peek is <= to end time, 
        add the interval
        calculate the max
        return the max;
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i=0; i<intervals.length; i++) {
            while(!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
            int qSize = pq.size();
            total = Math.max(total, qSize);
        }
        return total;
    }
}