//Time Complexity: O(nlogn)
//Space Complexity: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        pq.add(intervals[0][1]);

        for(int i=1;i < intervals.length; i++)
        {
            if(intervals[i][0] < pq.peek())
            {
                pq.add(intervals[i][1]);
            }
            else
            {
                pq.add(intervals[i][1]);
                pq.poll();
            }
        }
        return pq.size();
    }
}