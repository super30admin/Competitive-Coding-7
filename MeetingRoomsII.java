//T.C O(n log n)
//S.C O(n)
//LeetCode :   https://leetcode.com/problems/meeting-rooms-ii/description/

//Sort the meeting times with start time, use a Min Heap to identify the smallest end time (the earliest ending meeting)
// to utilize its room for next meeting. At the end, the size of min heap gives no. of rooms needed.

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    private static int rooms(int[][] meeting){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        Arrays.sort(meeting,(a, b)->a[0]-b[0]); //O(n log n)
        for(int[] interval: meeting){
            if(pq.size()>0 && pq.peek()<=interval[0])
                pq.poll();
            pq.add(interval[1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] meeting = new int[][]{{0,30},{5,10},{15,20}};
        for(int[] m: meeting)
            System.out.println(m[0]+" "+ m[1]);
        int res = rooms(meeting);
        System.out.println("No. of rooms:"+ res);
    }
}
