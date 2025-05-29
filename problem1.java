import java.util.Arrays;
import java.util.PriorityQueue;

//Time complexity:O(nlogn)
//Space complexity :O(n)
public class problem1 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals==null || intervals.length==0)
        {
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        for (int i=1;i<intervals.length;i++)
        {
            int currentStart= intervals[i][0];
            int currentEnd= intervals[i][1];
            if (currentStart>=minHeap.peek())
            {
                minHeap.poll();
            }
            minHeap.add(currentEnd);
        }
        return minHeap.size();
    }
}
