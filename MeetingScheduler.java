import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval () {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class MeetingScheduler {

    // Min heap solution
    // TC: O(n * log n) - number of intervals
    // SC: O(n)
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        // Sequentially align the intervals based on their start time
        Arrays.sort(intervals, (a,b) -> a.start - b.start);

        // Min heap based on the end time
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);

        // add first interval into thw pq and start the mean heap
        pq.add(intervals[0]);

        for(int i=1; i < intervals.length; i++) {
            Interval current = intervals[i];
            Interval earliest = pq.poll();

            // Check whether the top of the queue can be reused or not
            // Logically use the same conference room which was previously occupied
            if(current.start >= earliest.end) { // Update the end time of the earliest
                earliest.end = current.end;
            }else {
                pq.add(current);
            }

            // We removed an interval from the queue
            // Either updated or same as it was previously.So, put it back into the pq
            pq.add(earliest);
        }

        return pq.size();
    }
}
