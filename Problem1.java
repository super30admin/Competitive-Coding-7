//Meting ROoms - 2
//tc - O(nlogn)
//sc - O(n)
import java.util.*;
class Problem1{
    public static void main(String args[]){
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        Problem1 p = new Problem1();
        System.out.println(p.minMeetingRooms(intervals));

    }
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (int[] a, int[] b)-> a[0]- b[0]);
        int count = 1;
        //min heap of end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1;i< intervals.length; i++){
            //[5,10][15,20][0,30]
            if(intervals[i][0] >= pq.peek()){
                pq.poll();
            }
            
            pq.add(intervals[i][1]);
            
        }
        return pq.size();
        
    }
}
