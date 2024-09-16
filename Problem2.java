//time o(nlogn)
//space o(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        //sorting the array
        Arrays.sort(intervals, (a1,a2)-> a1[0]-a2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<intervals.length;i++) {
            if(!pq.isEmpty()) {
                if(intervals[i][0] >= pq.peek()) {
                    pq.poll();
                }
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}