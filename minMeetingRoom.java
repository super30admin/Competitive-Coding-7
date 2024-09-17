/**


An array of meeting time intervals is given to you where every element consists of starting and ending time [[Start1,end1],[Start2,end2],...] (Starti < endi),you are required to find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Queue which stores intervals in Ascending order.

TC - O(NlogN) + O(NlogN)
SC - O(N)
where N is the length of an intervals.
**/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        final Queue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for (int k=1; k<intervals.length; k++)
        {
            if (pq.peek() <= intervals[k][0])
            {
                pq.remove();
            }
            
            pq.add(intervals[k][1]);
        }
        
        
        return pq.size();
    }
}
