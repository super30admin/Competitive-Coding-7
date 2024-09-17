import java.util.Arrays;
import java.util.PriorityQueue;

//Time Complexity : O(NlogN)
//Space Complexity : O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
       Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
       if(pq.isEmpty()){
           pq.add(interval[1]);
           continue;
            }
        if(pq.peek() <= interval[0]){
            pq.poll();
        }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
