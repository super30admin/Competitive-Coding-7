/*
time complexity : O(n log n + n)
space complexity: O(n), in worst case
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static int countMeetingRomms(int[][]intervals){

        if(intervals.length == 0 || intervals == null)return 0;

        //sort the intervals according the start time.
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        //sort accoridng to start time
        Arrays.sort(intervals,comp);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //
        queue.add(intervals[0][1]);       //10
        for (int i =1; i < intervals.length;i++){
            int currEnd = intervals[i][1];
            int startTime = intervals[i][0];
            if (queue.peek() <= startTime){
                queue.poll();
            }
            queue.add(currEnd);  //15
        }

        return queue.size();
    }

    public static void main(String[] args) {
        int[][]intervals = {{0,5},{4,10},{3,7},{2,15}};

        int res = countMeetingRomms(intervals);
        System.out.println("minimum rooms:" + res);

    }
}
