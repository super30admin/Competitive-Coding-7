
// Problem: Meeting Rooms II (Leetcode #253)
//TC O(n log n)
//SC O(n)
var minMeetingRooms = function(intervals) {
    if (!intervals.length) return 0;

    // Sort by start time
    intervals.sort((a, b) => a[0] - b[0]);

    const heap = new MinHeap();
    heap.insert(intervals[0][1]); // Insert end time of first meeting

    for (let i = 1; i < intervals.length; i++) {
        const [start, end] = intervals[i];

        // If current meeting starts after the earliest ending one, reuse the room
        if (start >= heap.peek()) {
            heap.removeMin();
        }

        heap.insert(end);
    }

    return heap.size(); // Number of rooms needed
};