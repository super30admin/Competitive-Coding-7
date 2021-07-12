//Time Complexity : O(n log n) // sort nlogn+ heap nlogn
//Space Complexity :O(n) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. sort the array by the meeting start time
 * 2. compare rooms min end time is less than or equal to current start node time  remove element from heap and current element end time. 
 *  means we are using same room so count will not increase
 * 3. if not increase count and add element end time to heap.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(intervals[0][1]);
		int count = 1;
		for(int i = 1; i < intervals.length; i++){
			if(pq.peek() <= intervals[i][0]){
				pq.remove();
			}else {
				count++;
			}
			pq.add(intervals[i][1]);
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(new MinMeetingRooms().minMeetingRooms(new int[][] {{1,10},{5,15},{11,15}}));
	}
}
