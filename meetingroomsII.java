import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Tc : O(nlogn) Sc: O(n)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] >= pq.peek()) {

                pq.poll();
            }

            pq.add(interval[1]);
        }
        return pq.size();
    }
}