// Approach : Using Priority Queue
// Time : O(nlogn) + O(nlogn)
// Space : O(n) # worst case - all meetings collide then each meeting requires a new meeting room
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort based on start time
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Default Min Heap
        pq.add(intervals[0][1]); // add end times into the heap
        System.out.println(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // check the incoming meeting start time with top of the heap
            // then update with new end time
            if (intervals[i][0] >= pq.peek()) {
                pq.remove();
                pq.add(intervals[i][1]);
                System.out.println(intervals[0][1]);
            } else {
                pq.add(intervals[i][1]);
            }
        }

        return pq.size();
    }
}