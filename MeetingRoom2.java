//time complexity:O(n log n)
//space complexity:O(n)

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Sort by start time
        intervals.sort((a, b) -> a.start - b.start);

        // Min-heap to track the end times of ongoing meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            // If a meeting room is free, remove it from the heap
            if (!heap.isEmpty() && meeting.start >= heap.peek()) {
                heap.poll();
            }
            heap.add(meeting.end);
        }

        // The size of the heap tells us the minimum rooms required
        return heap.size();
    }
}

