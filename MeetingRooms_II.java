import java.util.Arrays;
import java.util.PriorityQueue;

//Time Complexity : O(nlogn)
//Space Complexity : O(n)
public class MeetingRooms_II {	
	/**Approach: Min Heap**/
	public int minMeetingRooms(int[][] intervals) {
		//null check
		if(intervals==null || intervals.length==0) return 0;
		
		//sort the intervals based on meeting start time
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int[] interval: intervals){ 
            //If any meeting ended on or before next meeting start time
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
        
	// Driver code to test above
	public static void main (String[] args) {
		MeetingRooms_II ob = new MeetingRooms_II();
		int[][] intervals = {{4,30},{5,10},{15,20},{2,4}};	//{{7,10},{2,4}};
						
		System.out.println("Minimun number of rooms required: "+ ob.minMeetingRooms(intervals));
	}
}
