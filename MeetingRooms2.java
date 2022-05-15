//TC : O(NLogN)
//SC : O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        pq.add(intervals[0][1]);
        for(int i=1;i<n;i++)
        {
            if(pq.peek() <= intervals[i][0])
            {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}