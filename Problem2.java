
//Time Complexity: O(nlogn)
//Space Complexity: O(n)

//we need to find the minimum number of meeting rooms required to hold all the meetings.

//we sort the intervals by start time and can use a min heap to store the end time of each meeting.
//we iterate through the intervals and for each interval, we check if the start time is greater than or equal to
//the end time of the meeting at the top of the min heap. if it is, we remove the meeting from the min heap.
//we then add the end time of the current meeting to the min heap.
//at the end, the size of the min heap will be the minimum number of meeting rooms

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 

        for (int[] time : intervals) {
            if (!pq.isEmpty()) {
                if (pq.peek()[1] <= time[0]) 
                    pq.poll();
            }
            pq.add(time);
        }

        return pq.size();
    }
}
