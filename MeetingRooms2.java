// Time Complexity : O(n log(n)) --> where n is the length of input 2D-Array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (253): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
	Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	pq.add(intervals[0][1]);
	for (int i = 1; i < intervals.length; i++) {
		int peekVal = pq.peek();
		if (intervals[i][0] >= peekVal) {
			pq.remove();
	        pq.add(intervals[i][1]);
		}
	    else pq.add(intervals[i][1]);
	}
	return pq.size();
}