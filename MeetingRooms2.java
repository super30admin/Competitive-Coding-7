//TC: O(n*logn)
//SC: O(n) for worst case
//approach: sort meetings by start time,
// and while iterating over sorted meetings, maintain a minheap of meetings by end time

import java.util.*;

public class MeetingRooms2 {
    public static void main(String[] args) {

        int[][] input = new int[][]{{0, 30}, {11, 50}, {15, 20}};
        System.out.println(meetingRoom(input));
    }

    public static int meetingRoom(int[][] input) {
        Arrays.sort(input, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] meeting : input) {
            if (!heap.isEmpty() && heap.peek() <= meeting[0]) {
                heap.remove();
            }
            heap.add(meeting[1]);
        }
        return heap.size();
    }

}
