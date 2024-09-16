import java.util.Arrays;
import java.util.PriorityQueue;

//Time Complexity : n + logn + nlogn (longn for sorting the array + nlogn for priority queue heapify + n for traversing the array )
//Space Complexity : logn in priority queue
//Runs successfully on leetcode
//No problem

//Here we will be sorting the elements based on the starting time of the meeting
//We'll also have a queue sorted with ending time of the meeting
//While traversing through the array of meeting, if there's any clash between starting of the meeting and ending of the first meeting
//from priority queue, we'll be adding meeting in priority queue
//In the end, we'll just return the size of the priority queue


public class Competitive_Coding_7_Problem_2_meetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));

        for(int[] i : intervals)
        {
            if(!pq.isEmpty() && i[0] >= pq.peek()[1])
            {
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();

    }
}
