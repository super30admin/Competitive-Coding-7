import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for( int [] time : intervals){
            if(pq.size()>0 && pq.peek() <= time[0]){
                pq.poll();
            }

            pq.add(time[1]);
        }

        return pq.size();

    }

}