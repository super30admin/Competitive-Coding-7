/**
 * Time: O(NlogN) N-size of the intervals matrix
 * Space: O(N)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        if(intervals.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 1;
        pq.offer(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(pq.peek() <= intervals[i][0])
            {
                pq.offer(Math.max(pq.poll(),intervals[i][1]));
            }else{
                pq.offer(intervals[i][1]);
                cnt++;
            }
        }
        return cnt;
    }
}