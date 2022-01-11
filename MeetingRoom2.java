// Time Complexity: sorting array and making priority queue -> O(nlogn) + O(nlogn) - > O(nlogn)
// Space Complexity: priority queue space O(n)
public class MeetingRoom2 {
    public class Interval 
    {
        int start, end;
        Interval(int start, int end) 
        {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
            return 0;
        
        // sort according start time
        Comparator<Interval> intervalCmp = new Comparator<Interval>()
        {
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        };
        Collections.sort(intervals, intervalCmp);
        // all rooms sorted by the meeting ending earliest at the top
        PriorityQueue<Integer> pq = new PriorityQueue<>();        

        for(Interval currMeeting : intervals)
        {
            if(pq.isEmpty()) // no rooms allocated create a meeting room
            {
                pq.add(currMeeting.end);
            }
            else
            {
                int meetingEndingFirst = pq.peek(); // get the room for which meeting ends early
                if(currMeeting.start > meetingEndingFirst) // if the new meeting starts after the meeting ending, re-use this room
                {
                    pq.poll(); // since now this end time is not important anymore
                }
                pq.offer(currMeeting.end);
            }
        }
        
        return pq.size(); // total number of rooms allocated
    }
}
