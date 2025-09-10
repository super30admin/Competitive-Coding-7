import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
//Idea is to sort the array based on the start time and then use min heap based on end time to merge the intervals.

//Time Complexity: O(nlogn)
//Space Complexity: O(n)
public class meetingroomsii {
        public int minMeetingRooms(List<Interval> intervals) {
    if(intervals==null|| intervals.size()==0) return 0;
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a- b);
    pq.add(intervals.get(0).end);
    for(int i=1;i<intervals.size();i++)
    {
       Integer fel = pq.peek();
       if(fel<=intervals.get(i).start)
       {
          pq.poll();
       }
          pq.add(intervals.get(i).end);
    }

    return pq.size();

    }
}
