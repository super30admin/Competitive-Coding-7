import java.util.Arrays;
//Time Complexity : O(NlogN)
//Space Complexity : O(N) for arrays
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Separate the starts and ends and then sort them in ascending order. Then
 * compare each start with each end with two pointers. If start is less than
 * end, then increment count and store the max count. If start is after the end,
 * then decrement count. return the max count found.
 *
 */
class Solution {
	public int minMeetingRooms(int[][] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);
		int count = 0;
		int i = 0, j = 0;
		int max = 0;
		while (i < intervals.length && j < intervals.length) {
			if (start[i] < end[j]) {
				count++;
				i++;
			} else if (start[i] >= end[j]) {
				count--;
				j++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
}