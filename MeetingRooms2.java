//https://leetcode.com/problems/meeting-rooms-ii/
/*
Time: O(NlogN) where n = intervals.length
Space: O(N) for the PriorityQueue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length <= 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length);
        pq.offer(0);

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] >= pq.peek())
                pq.poll();

            pq.offer(intervals[i][1]);

        }

        return pq.size();
    }

}
