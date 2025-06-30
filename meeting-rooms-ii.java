//Minheap:
//Sort the intervals based on start time
//Use a min-heap to track the end times of ongoing meetings
//For each meeting,
// - If meeting at the top of the heap has ended before or at the current meeting's start time then reuse that room, pop from heap.
// - Else, push new room to heap.
// After all meetings processed, the size of the heap will be the number of rooms needed.
// Time Complexity: O(nlogn) for sorting + O(nlogn) for heap operations = O(nlogn)
// Space Complexity: O(n) for the heap

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int i=0; i<intervals.length; i++){
            if(!pq.isEmpty()){
                if(pq.peek() <= intervals[i][0]){
                    pq.poll();
                }
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}