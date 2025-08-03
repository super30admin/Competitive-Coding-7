// TC: O(n logn)
//SC: O(n) for Priority Queue

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals,((a,b) -> a[0] - b[0]));
        
        int n = intervals.length;

        for(int i=0;i<n;i++){
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            if(pq.size() == 0 || pq.peek() > startTime)
            {
                pq.add(endTime);
            }
            else{
                pq.poll();
                pq.add(endTime);
            }
        }
        return pq.size();
    }
}
