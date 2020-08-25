import java.util.*;
//Time Complexity : O(m*n log m*n)=> O(NlogN), length of intervals
//Space Complexity :O(m*n)=> O(N), size of heap
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : No

/**Using Priority Queue(Min Heap)
 * Sort the intervals based on the starting time of each meeting
 * If a meeting start time is greater than the previous meetings end time, extra room is not needed, otherwise its needed
 * */
public class MeetingRooms_II {
	public static int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, (a,b) -> a[0]-b[0]);	//sort based on start time
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);	//Add First finish time in to queue
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][0] >= pq.peek())	// If start time > prev meetings end time, not need an extra meeting room
				pq.poll();
			
			pq.add(intervals[i][1]);
		}
		return pq.size();
	}
	public static void main(String[] args) {
		int[][] intervals = {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(intervals));
	}
}
