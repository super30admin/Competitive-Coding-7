// Time Complexity : O(n log n) sorting and heap
// Space Complexity : O(n) priority queue max size
// Did this code successfully run on Leetcode : Yes

// Approach:
// Sort the meetings by start time.
// Use a minHeap to track end times and remove meetings that have ended before new one starts.
// Size of the heap at the end gives the minimum number of rooms needed.

import java.util.*;
class Solution{
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] interval:intervals){
            if(!pq.isEmpty() && pq.peek()<=interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}