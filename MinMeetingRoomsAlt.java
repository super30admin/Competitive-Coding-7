//Time Complexity : O(n+max) // max is maximum end time
//Space Complexity :O(10 pow 6) can say O(1) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. create an array of 10 pow 6 length as condition. 
 * 2. on each start time index increase by 1 and on each end time index decrease by 1.
 * 3. then similar to DP loop through array and find max value.
 */

public class MinMeetingRoomsAlt {

	public int minMeetingRooms(int[][] intervals) {
		int mx=0;
		int maxValue = 0;
		int n = intervals.length;
	    int[] arr= new int[1000001];

	    for(int i = 0; i < n; i++) {
	        int s = intervals[i][0];
	        int e = intervals[i][1];
	        mx = Math.max(mx, e);

			arr[s] += 1;
	        arr[e] -= 1;
	    }
		
	    int presum = arr[0];
	     
	    for(int i = 1; i <= mx; i++) {
	        presum = presum + arr[i];
	        maxValue = Math.max(maxValue, presum);
	    }

	    return maxValue;
	}
	public static void main(String[] args) {
		System.out.println(new MinMeetingRoomsAlt().minMeetingRooms(new int[][] {{1,10},{5,15},{11,15}}));
	}
}
