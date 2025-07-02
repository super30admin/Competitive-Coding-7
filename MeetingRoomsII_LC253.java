//Time Complexity: O(n log n)
//Space Complexity: O(n) for heap
//Did this code successfully run on Leetcode: YES
//Any problem you faced while coding this: None

public class MeetingRoomsII_LC253 {
    public static void main(String[] args) {
        int r = minMeetingRooms({{0,30},{5,10},{15,20}});
        System.out.println("result : " + r);
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart >= heap.peek())
                heap.poll();

            heap.add(currentEnd);
        }

        return heap.size();
    }
}