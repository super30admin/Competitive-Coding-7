/*
  Time complexity: O(n)
  Space complexity: O(1)

*/

public class Solution {
    public int MinMeetingRooms(int[][] intervals) {
        int rooms = 0;

        if(intervals.Length==0)
            return rooms;

        int[] startIntervals = new int[intervals.Length];
        int[] endIntervals = new int[intervals.Length];

        for(int i=0;i<intervals.Length;i++)
        {
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
        }
        Array.Sort(startIntervals);
        Array.Sort(endIntervals);

        int startPointer = 0;
        int endPointer = 0;

        while(startPointer<intervals.Length && endPointer<intervals.Length)
        {
            if(endIntervals[endPointer]<=startIntervals[startPointer])
            {
                rooms--;
                endPointer++;
            }
            rooms++;
            startPointer++;
        }
        return rooms;
    }
}
/*
1,6,13
9,13,15


9>1 rooms=1 startPointer=1 endPointer=0
9>6 rooms=2 startPointer=2 endPointer=0
9<13 rooms=1 startPointer=2 endPointer=1
13=13 rooms=0 startPointer=2 endPointer=2
15>13 rooms=1 startPointer=3 endPointer=2

*/
