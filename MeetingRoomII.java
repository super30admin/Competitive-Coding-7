// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {

        // Sorting Array
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.add(interval[1]);
                continue;
            }
            // check for colliding intervals
            if (pq.peek() <= interval[0]) {
                pq.poll();
            }

            pq.add(interval[1]);

        }

        return pq.size();

    }
}