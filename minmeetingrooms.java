import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.*;


//  * Definition of Interval:
class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
 }
 //TC-O(nlogn), SC-O(K)

class Solution {

    public int minMeetingRooms(int[][] intervals) {
        // Write your code here
        if(intervals.length==0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        pq.add(intervals[0][1]);
        for(int j = 1;j<intervals.length;j++){
            if(pq.peek() < intervals[j][0]){
                pq.poll();
            }
            pq.add(intervals[j][1]);
        }
        return pq.size();
    }
    public static void main(String[] args){
        int[][] ip = {{0, 30},{5, 10},{15, 20}};
        Solution obj = new Solution();
        System.out.println(obj.minMeetingRooms(ip));
        
    }
}

