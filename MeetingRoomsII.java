/*
Approach: Using min heap/priority queue

What we will do is first sort the intervals by their start time. 

Then we first push the first meeting's end time into the min heap. Now we iterate through the intervals and compare their start time with the minimum end time present in the heap.
If an interval's start time is greater than the minimum end time in the heap, that means we can use that room later and replace the end value of current min value in heap with end time of current interval but if vice versa is true then we need to get another room.

So at the end of iteration size of the heap is number of rooms we need.

Time complexity: O(nlogn)
Space complexity: O(k)

Where n = no of intervals
k = max rooms required
*/

import java.util.*;

class Solution{
	public static int meetingRooms(int [][] intervals){
		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);

		for(int i = 1; i < intervals.length; i++){
			int value = pq.peek();
			if (intervals[i][0] > value){
				pq.remove();
				pq.add(intervals[i][1]);
			}
			else{
				pq.add(intervals[i][1]);
			}
		}
		return pq.size();
	}

	public static void main(String[] args){
		int[][] intervals = {{0,30}, {5,10}, {15,20}};
		int ans = Solution.meetingRooms(intervals);
		System.out.println(ans);
	}
}