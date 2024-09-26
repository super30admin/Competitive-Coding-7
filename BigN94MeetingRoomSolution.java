// Time complexity is O(nlogn)
// space complexity is O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

public class BigN94MeetingRoomSolution {

	public int meeting(int[][] interval) {
		// edge case
		if (interval == null || interval.length == 0)
			return 0;
		Arrays.sort(interval, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(interval[0][1]);
		for (int i = 1; i < interval.length; i++) {
			int val = pq.peek();
			if (val > interval[i][0]) {
				pq.add(interval[i][1]);
			} else {
				pq.remove();
				pq.add(interval[i][1]);
			}
		}
		return pq.size();
	}

	public static void main(String args[]) {
		BigN94MeetingRoomSolution meet = new BigN94MeetingRoomSolution();
		// int [][] interval = {{0,30},{5,10},{15,30}};
		int[][] interval = { { 0, 30 }, { 5, 32 }, { 15, 20 }, { 6, 9 } };
		System.out.println(meet.meeting(interval));
	}
}
