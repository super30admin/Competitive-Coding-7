//time complexity- O(nlogn)
//space complexity- O(n)
import java.util.*;
public class MeetingRoomsTwo {
    static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] time : intervals){
            if(!pq.isEmpty() && pq.peek() <= time[0]) pq.poll();
            pq.offer(time[1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] interval = {{2, 4}, {9, 12}, {6, 10}};

        System.out.println("Minimum number of meeting rooms needed are: " + minMeetingRooms(interval));
    }
}
