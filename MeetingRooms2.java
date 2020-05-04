//time - O(number of meetings * log(number of rooms needed))
//space - O(number of rooms needed) for the heap

public class MeetingRooms2 {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));
    }
    public static int findMinNoOfMeetingRooms(Interval[] intervals) {
        //edge
        if(intervals == null || intervals.length == 0)
        {
            return 0; //no meeting rooms needed
        }
        
        //sort the intervals based on incresing oreder of start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        //prority queue to have the end times of all meeting rooms
        PriorityQueue<Integer> output = new PriorityQueue<>();
        for(Interval current : intervals)
        {
            if(output.size() == 0 || output.peek() < current.start)
            {
                //pq is empty or the min end time is smaller than start time of current
                //so current needs a new room
                output.offer(current.end);
            }
            else
            {
                //current starts on or after end time of room at root of heap
                //so update the end time of this root
                output.remove();
                output.offer(current.end);
            }
        }
        return output.size();
    }
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
