/*
 * Sort the intervals array to get meetings sorted by starting time
 * Use min heap to keep track of the ending time of the meeting to compare it with the starting time of the current meeting
 * If the current meetings starting time is less than or equal to the min ending time, then we can utilize the same conference room.
 * At the end return the size of the min heap as that many conference rooms will be needed
 * TC: O(nlogn) -> iterate over all the intervals, and insertion in heap of n intervals worst case
 * SC: O(n) -> worst case, store all the intervals in the heap
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, ((a,b) -> a[0] - b[0]));
        
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            if(pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}