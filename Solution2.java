package compcoding;
//Time Complexity:O(Nlogn)
//Space Complexity: O(n)
public class Solution2 {
	public int meetingrooms(int[][] intervals){
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);	//sort based on start times
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int[] interval : intervals){
			int start = interval[0];
			int end = interval[1];

			if(pq.isEmpty() || start < pq.peek())
				pq.add(end);
		}
		else{
			pq.poll();
			pq.add(end);
		}
	}
	return pq.size();
}
}
