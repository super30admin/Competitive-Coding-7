// TC: O(N LOG N)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static int meetingRooms(int[][] intervals){
        if(intervals.length == 0) return 0;


        Arrays.sort (intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        pq.add (intervals[0][1]);

        for(int i = 1; i < intervals.length;i++){

            int peekValue = pq.peek ();

            if(intervals[i][0] > peekValue ){
                pq.remove ();
                pq.add (intervals[i][1]);
            }else{
                pq.add (intervals[i][1]);
            }

        }
        return  pq.size ();
    }


    public static void main(String[] args) {

        //MeetingRooms sol = new MeetingRooms ();

        int[][] intervals = {{0,30},{5,10},{15,20}};

        int ans = MeetingRooms.meetingRooms (intervals);
        System.out.println (ans);
    }
}
