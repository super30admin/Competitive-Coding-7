import java.util.Arrays;
import java.util.PriorityQueue;

//Tc O(n log n)
//Sc O(n)
class meetingRoomTwo {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        //Sort meetings by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //Min Heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {
            // If earliest meeting has ended remove it
            if (!minHeap.isEmpty() && minHeap.peek() <= meeting[0]) {
                minHeap.poll();  // Remove ended meeting
            }
            minHeap.add(meeting[1]); // Add current meeting's end time
        }

        //Heap size = min rooms required
        return minHeap.size();
    }

    public static void main(String[] args) {
        meetingRoomTwo obj = new meetingRoomTwo();
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(obj.minMeetingRooms(meetings));  // Output: 2
    }
}
