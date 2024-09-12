//time complexity: O(N log N)
//space complexityL O(N)

import java.util.*;

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class MinimumMeetingRooms {

  public static int findMinimumMeetingRooms(List<Meeting> meetings) {
   
    int i = 0;
    int count = 1;
    int t = Integer.MAX_VALUE;
    Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

    while (i < meetings.size() - 1)
    {
      if (meetings.get(i).end >= meetings.get(i+1).start)
      {
        t = Math.min(t, meetings.get(i).end);
        count++;
        if ( t <= meetings.get(i+1).start)
        {
          count--;
        }
      }
      i++;
    }    
    return count;
  }
}