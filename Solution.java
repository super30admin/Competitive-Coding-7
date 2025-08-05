//TC : O(n log n)
//SC: O(n)
class Solution {
 public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) return 0;

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int[] interval : intervals) {
        int stT = interval[0];
        int endT = interval[1];

        if (!pq.isEmpty() && pq.peek() <= stT) {
            pq.poll();
        }

        pq.offer(endT); 
    }

    return pq.size();  
}
}