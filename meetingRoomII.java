import java.util.Arrays;
import java.util.PriorityQueue;

// Time Complexity : nlog(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class meetingRoomII {

    public int meetings (int[][] interval){

        //base case
        if(interval.length==0 || interval[0].length==0)
            return 0;

        //logic   

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Arrays.sort(interval, (a,b) -> a[0]-b[0]); // min heap 
        
        for( int[] x:interval){
            pq.add(x[1]); // initial min-heap
            if(pq.peek()<=x[0])
                pq.poll();
            }

        return pq.size();

    }
    
}
