/*
TC --> O(nlogn)
SC --> O(n) for the heap
 */
class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //O(nlogn)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int startTime;
        int endTime;
        int rooms = 1;

        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            startTime = intervals[i][0];
            endTime = intervals[i][1];
            if (startTime < pq.peek()) {
                pq.add(endTime);
            }//if
            else {
                pq.poll();
                pq.add(endTime);
            }
        }//for

        return pq.size();

    }
}
