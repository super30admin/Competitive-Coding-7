// Time Complexity : O(n + m) [n: numbers of rows in the 2-D intervals Array; m: 10^6 constriant]
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : No, premium problem
// Any problem you faced while coding this : No


import java.util.* ; 
class Solution {
	public int minRooms(int[][] intervals) {

		// return helperBruteForce(intervals);
		// return helperTwoPtr(intervals);
		// return helperMinHeapPQ(intervals);
		return helperRunningSum(intervals);

	}

	public int helperRunningSum(int[][] intervals) {
		int n = (int) Math.pow(10, 6) + 1;
		int timeMap[] = new int[n];

		for(int arr[] : intervals) {
			++timeMap[arr[0]];
			--timeMap[arr[1]];
		}

		int res = 1;

		for(int i = 1; i < n; i++) {
			timeMap[i] += timeMap[i - 1];
			res = Math.max(res, timeMap[i]);
		}

		return res;
	}

    //Tc: O(nlogn + n)
    //SC: O(n)
	public int helperMinHeapPQ(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int arr[] : intervals) {
			if(!pq.isEmpty() && pq.peek() <= arr[0]) {
				pq.poll();
			}
			pq.offer(arr[1]);
		}

		return pq.size();
	}

    //Tc: O(2*nlogn + 2n)
    //sc: O(2n)
	public int helperTwoPtr(int[][] intervals) {
		int n = intervals.length;
		int st [] = new int [n];
		int et [] = new int [n];

		for(int i = 0; i<n; i++) {
			st[i] = intervals[i][0];
			et[i] = intervals[i][1];
		}
		Arrays.sort(st);
		Arrays.sort(et);

		int rooms = 1;
		int cet = 0;

		int i= 1;		
		while(i < n) {
			if((st[i] < et[cet])) {
				rooms++;
			} else {
				cet++;
			}

			i++;
		}

		return rooms;
	}

    //Tc: O(nlogn + n^2)
    //Sc: O(n)
	public int helperBruteForce(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));

		List<Integer> endTimesList = new ArrayList<>();

		for(int arr[] : intervals) {
			int size = endTimesList.size();
			boolean isNotScheduled = true;
			for(int i = 0; i < size; i++) {
				if(arr[0] >= endTimesList.get(i)) {
					endTimesList.set(i, arr[1]);
					isNotScheduled = false;
					break;
				}
			}

			if(isNotScheduled) {
				endTimesList.add(arr[1]);
			}
		}

		return endTimesList.size();
	}
}