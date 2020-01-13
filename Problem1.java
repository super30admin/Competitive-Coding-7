/**
LeetCode Submitted : YES
Space Complexity : O(Number of timestamp tuples)
Time Complexity : O(NlogN) + O(NlogN)

The idea is to use Min Heap to store the finish time of the meeting rooms such that at each iteration we are checking start time with minimum finishing time from heap to see if we can schedule anything paralley. Otherwise we need to schedule it in different conference rooms.

**/
public int  findConf(int[] timestamp){
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	Arrays.sort(timestamp,(a,b) -> Integer.compare(a[0],b[0]));

	for(int[] t : tmimestamp){	
		if(!pq.isEmpty()){
			int  top_timestamp = pq.peek();
			if(top_timestamp < t[0]) //i can schedule parallel{
				pq.poll();
				pq.add(t[1]);
			}else{
				pq.add(t[1]);	
			}
		
		}else{
			pq.add(t[1]);
		}
	return pq.size();

}
