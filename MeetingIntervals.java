// Time Complexity : O((m+n)log(m+n)). m+n is the total elements in a 2D array
// Space Complexity : O(k). k is the minimum number of meeting rooms 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



import java.util.Arrays;
import java.util.PriorityQueue;
public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		  System.out.println(sol. minMeetingRooms(new int[][] { {0,30}, {5,10}, {15,20}
		  }));
		
		System.out.println(sol.
				minMeetingRooms(new int[][] { { 7,10 },
					{2,4}
				}));
		
	}
	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		PriorityQueue<Integer> pq =
				new PriorityQueue<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			int[] arr = intervals[i];
			if (i == 0) {
				pq.add(arr[1]);
			} else {
				if (arr[0] > pq.peek()) {
					pq.poll();
					pq.add(arr[1]);
				} else
					pq.add(arr[1]);
			}
		}
		return pq.size();
	}
}
