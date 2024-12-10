import java.util.*;

public class Problem1 {
    //TC :O(NLogN)
    //SC :O(N)
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            int st =  intervals[i][0];
            int et =  intervals[i][1];
            if(!pq.isEmpty() && pq.peek()<=st){
                pq.poll();

            }
            pq.add(et);



        }
        return pq.size();
    }
}
