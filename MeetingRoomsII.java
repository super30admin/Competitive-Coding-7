//TC = O(N*Log N)
//SC = O(N)

import java.util.*;
public class MeetingRoomsII {
    
    public static int meetingRooms(int[][] intervals)
    {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1 ; i < intervals.length;i++)
        {
            if(pq.peek()<= intervals[i][0])
            {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

    public static void main(String args[])
    {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(meetingRooms(intervals));
    }

}
