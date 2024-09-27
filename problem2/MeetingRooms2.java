//Time Complexity : O(nlogn), n -> Number of meetings
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		queue.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (queue.peek() <= intervals[i][0]) {
				queue.poll();
			}
			queue.add(intervals[i][1]);
		}

		return queue.size();
	}

	public static void main(String[] args) {
		MeetingRooms2 obj = new MeetingRooms2();
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };

		System.out.println("Minimum number of meeting rooms required: " + obj.minMeetingRooms(intervals));
	}

}
