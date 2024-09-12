import java.util.*;
public class meetingRoomsII {

	public int NumberMeetingRooms(int[][] intervals) {
		
		if(intervals == null || intervals.length == 0)
			return 0;
		// Sorting the array with the start time intervals
		Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
		// priority Queue so that we can store the intervals in ascending order with the end time
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
		pq.add(intervals[0]);
		// add the first interval onto priority queue
		
		for(int i=0;i<intervals.length;i++) {
			// fetch the current meeting
			int[] currMeeting = intervals[i];
			// fetch the earliest meeting, since we have sorted the intervals in end time ascending order, that will be our earliest interval
			int[] earliest = pq.poll();
			// if the start time of current meeting is greater than end time of earliest meeting time, we know that the intervals can be merged
			// since we can accomodate both the meetings in same room, one meeting after another, so we can combine them such that
			// we get only one meeting room, so, we update our earlist end time meeting and discard the current meeting.
			if(currMeeting[0] >= earliest[1]) {
				earliest[1] = currMeeting[1];
			}else {
				// if the start time of current meeting is less than  end time of earliest meeting, we know that we need separate meeting rooms
				// for both current and earliest meeting, we will add that to our queue, which is storing all the meeting rooms of intervals
				pq.add(currMeeting);
			}
			
			// we are adding back the earliest polled meeting because in future, we might come across any meetings whose size is greater than
			// earliest meeting, so should add it back and also to keep our count of meeting rooms
			pq.add(earliest);
		}
		// we need to just return the queue size since we are merging all intervals which come one after another and separate intervals
		// these intervals are nothing but they form separate meeting rooms
		return pq.size();
	}
}
