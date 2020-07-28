Approach 1 : Compute the total no. of passengers at every given destination. Add the no. of passenger at the start and subtract the no. of passengers at the end. Add the total no. of passengers at every position. If the capacity is full at any point return false.
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
		int[] count = new int[1001];
		for (int i = 0; i < trips.length; i++) {
			count[trips[i][1]] += trips[i][0];
			count[trips[i][2]] -= trips[i][0];
		}
		int curr = 0;
		for (int i : count) {
			curr += i;
			if (curr > capacity) {
				return false;
			}
		}
		return true;
	}
}
Approach 2:  Using priority queue and sorting
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {	
        Arrays.sort(trips, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
             public int compare(int[] t1, int[] t2) {
                 return t1[2] - t2[2];
             }
        });// Searched web, was not able to figure out the comparator.
        for (int i = 0; i < trips.length; i++) {
            while (!pq.isEmpty() && pq.peek()[2] <= trips[i][1]) {
                capacity += pq.peek()[0];
                pq.poll();
            }
            capacity -= trips[i][0];
            pq.offer(trips[i]);
            if( capacity < 0 )
                return false;
        }
        return true;
    }
}