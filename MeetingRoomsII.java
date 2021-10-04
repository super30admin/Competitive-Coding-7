// https://leetcode.com/problems/meeting-rooms-ii/

/*Sort the intervals according to the starting time.
Use a minHeap(pq) to save the endTime for all intervals according to the order of start time.
Add end time to the pq.
if cur start time < pq.peek() => means current start time is before first ending time, which means we must have a new room.
if cur start time >= pq.peek() => means we can use this room for the meeting, we poll out the the original period and add current period to the pq(Means we update the room with the new meeting).
*/
class MeetingRoomsII {

    // Time Complexity: O(nlogn)    (where n -> no. of intervals in the array)
    // Space Complexity: O(n)

    class Solution {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int [] interval : intervals){

            if(pq.size() > 0 && pq.peek() <= interval[0]){

                pq.poll();

            }

            pq.add(interval[1]);

        }

        return pq.size();

    }

}

//approach 2: Using two pointer and sorting 
// TC: O (N LOG N)
// SC: O(N) 

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        
        if(len == 1) return 1;
        int[] start = new int[len]; // contains the start time of each interval
        int[] end = new int[len]; // contains the end time of each interval
        
        for(int i = 0; i < len; i++) { // populate the arrays
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int reqMeetingRooms = 0;
        int endIdx = 0;
        
        for(int startIdx = 0; startIdx < len; startIdx++) { 
            if(start[startIdx] < end[endIdx]) reqMeetingRooms++;
            else endIdx++;
        }
        
        return reqMeetingRooms;
    }
}