import java.util.Arrays;
import java.util.PriorityQueue;

// Time Complexity :O(nlog(k))
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class MeetingRoomsII {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            //[[0,30],[5,10],[15,20]]

            if(intervals == null || intervals.length == 0) return 0;

            //sort in ascending order based on start time
            Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

            //create min heap
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            //add end time to minHeap with each iteration and remove root node when end time <= start time
            for(int[] interval:intervals){
                if(!minHeap.isEmpty()&&minHeap.peek() <= interval[0]) minHeap.poll();
                minHeap.add(interval[1]);
            }
            //return size of minheap to indicate min number of rooms needed
            return minHeap.size();
        }
    }

}
