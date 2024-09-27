
//TC - O(NlogN)
//SC - O(N)
import java.util.*;

class Solution1 {
	public int minMeetingRooms(int[][] intervals) {
		// edge
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(final int[] a, final int[] b) {
				return a[0] - b[0];
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			int curr_start = intervals[i][0];

			if (curr_start >= pq.peek())
				pq.poll();
			pq.add(intervals[i][1]);
		}
		return pq.size();
	}
}