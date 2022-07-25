// Time Complexity : O(nlogn) sorting of heap
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        for(int i=0;i<intervals.length;i++){
            if(pq==null){
                pq.add(intervals[i][1]);
            }
            else{
                //int curr = pq.peek();
                if(!pq.isEmpty() && pq.peek()<=intervals[i][0]){
                    pq.poll();
                }
                pq.add(intervals[i][1]);
//                 if(curr[1]>intervals[i][0]){
//                 }
//                 else{
//                     pq.poll();

//                 }
            }
        }

        return pq.size();
    }

    public static void main(String [] args){
        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.minMeetingRooms(new int[][]{{0,10},{15,20},{5,10}}));
    }
}

