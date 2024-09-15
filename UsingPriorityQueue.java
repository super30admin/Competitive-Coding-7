public class Interval
{
    int start;
    int end;
    public Interval()
    {
        start = 0 ; end =0;
        Interval(int s , int e)
        {
            start = s;
            end = e;
        }
    }
}

class UsingPriorityQueue() {
    //TC: O(NlogN) n = size of intervals[]
    //SC : O(N)
    public int minMeetingRooms(Interval[] intervals) {
        //Intervals [0,30], [5,10] , [15,20]

        if (intervals.length == 0 || intervals.size == 0) {
            return 0;
        }

        //Sort the intervals on start times
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        // Maintaining minheap to compare earliest "ending" meeting
        PriorityQueue<Interval> minHeap = new PriorityQueue((a, b) -> a.end - b.end);
        //Add the first meeting;
        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current = intervals[i];
            Interval min = minHeap.remove();
            if (current.start >= min.end) {
                // To maintain the root node as min, we can change end time of min to reflect end time of the current meeting room
                //   as we dont need new meeting room.
                min.end = current.end;

            } else {
                minHeap.add(current);
            }
            minHeap.add(min);
        }
        return minHeap.size();

    }
}

    class WithoutPriorityQueue()
    {

        //TC: O (nLogn for sorting + O(n))
        //SC: O(n)

        public int minMeetingRooms(Interval[] intervals)
        {
            //Keep start times and end times sorted for each intervals in two separate arrays


            if (intervals.length ==0 || intervals.size ==0)
            {
                return 0;
            }

            int intervalSize = intervals.size();
            int[] start = Arrays.sort( intervals ,(a,b) -> a.start-b.start);
            int[] end = Arrays.sort(intervals , (a,b) -> a.end -b.end);

            //maintain two pointers i = start , j = end;
            int i = 1 ; j =0 ; room =1; // Assuming ist meeting is already in room 1 ; so start looking from 2nd meetings start time and compare with ending of the meeting;
            int maxRoom = 1;
            while(i < start.length && j < end.length)
            {
                if (start[i] < end[j]) // end of shortest meeting is greater than start of end meeting, we need new room
                {
                    room++;
                    i++;
                }
                else
                {
                    room--;
                    j++;
                }
                maxRoom = Integer.max(room , maxRoom);
            }
          return maxRoom;
        }

    }



}