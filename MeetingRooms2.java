
// Time Complexity : O(NLogK)
// Space Complexity : O(NlogK)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Approach:
1) we have been provided with the start and end time of the meetings
2) we sort the elements with the start time, which will give us the start timings of the meetings
3) Now we use a priorityQueue to hold the end times (Min heap).
4) if endTime > startTime 
         // allocate another room
         // else 
         // use same room, just update the end time with the greater
5) if(!pqueue.isEmpty())// if not empty do the action
             {
                 if(pqueue.peek()<=intervals[i][0]) // if end time < start time
                 {
                     pqueue.poll();
                 }
                 
             }
    // takes care of the above part
6) we only add the end times in the priority queue
7) we store the end times in queue and the number of end times would indicate the number of rooms, thus we return the pqueue.size() as number of rooms
*/

import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        
        
        // sorting acc to start times 
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
         
         
         // storing all the end times
         // we have a min heap here
         PriorityQueue<Integer> pqueue = new PriorityQueue<>();
         
         
         // if endTime > startTime 
         // allocate another room
         // else 
         // use same room, just update the end time with the greater
         
         
         for(int i=0;i<intervals.length;i++)
         {
             if(!pqueue.isEmpty())// if not empty do the action
             {
                 if(pqueue.peek()<=intervals[i][0]) // if end time < start time
                 {
                     pqueue.poll();
                 }
                 
             }
             
             // push in the pqueue
             pqueue.add(intervals[i][1]); // add only the end times
             
         }
         
         return pqueue.size();
     }
}
