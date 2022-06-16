using System;
namespace Algorithms
{
    public class MeetingRooms2
    {
        /// Time Complexity : O(nLogn) 
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int minMeetingRooms(int[][] intervals)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            Arrays.sort(intervals, (a, b)->a[0] - b[0]);
            for (int[] interval : intervals)
            {
                if (!pq.isEmpty() && pq.peek() <= interval[0])
                {
                    pq.poll();
                }
                pq.add(interval[1]);
            }
            return pq.size();
        }
    }
}
