package mediumProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//Time Complexity: O(nlogn)
//Space Complexity: O(k)

public class MeetingRooms {

	
	private int findRooms(int[][] arr)
	{
		//base case
		if(arr == null || arr.length ==0)
			return 0;
		
		//if there is only 1 meeting
		if(arr.length == 1)
			return 1;
		
		//sorting the array in ascending order on start time
		Arrays.sort(arr, (a,b) -> a[0]-b[0]);
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.add(arr[0][1]);
		
		for(int i=0; i<arr.length; i++)
		{
			if(minHeap.peek() < arr[i][1])
			{
				minHeap.poll();
				minHeap.add(arr[i][1]);
				
			}else
			{
				minHeap.add(arr[i][1]);
				
			}
		}
		
		return minHeap.size();
	}
	
	public static void main(String[] args) {
		
		MeetingRooms test = new MeetingRooms();
		int[][] arr = {{5,10}, {0,30}, {5,7}, {15,20}};
		//int[][] arr = {{ 0, 30 }, { 5, 32 }, { 15, 20 }, { 6, 9 }};
		//int[][] arr = {{5,10}};
		System.out.println("Total number of rooms required: "+test.findRooms(arr));

	}

}
