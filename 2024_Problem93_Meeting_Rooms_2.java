//253. Meeting Room 2 - https://leetcode.com/problems/meeting-rooms-ii/description/
//Time Complexity: O(nlog(n))
//Space Complexity: O(n) ~ Heap space

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        //base case
        if(n == 0)
            return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 1;
        pq.add(intervals[0][1]);

        for(int i = 1; i<intervals.length; i++)
        {
            if(intervals[i][0]>=pq.peek())
            {   //pq.peek() will give us the meeting with minimum ending time.
                pq.poll();
            }else{
                //if no such meeting is present, then we need new room;
                rooms++;
            }
            pq.add(intervals[i][1]);
        }
        return rooms;
    }
}