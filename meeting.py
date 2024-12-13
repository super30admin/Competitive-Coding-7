# The minMeetingRooms method calculates the minimum number of meeting rooms required.

# Sort intervals by start time.
# Use a min-heap to track end times of meetings:
# - If the earliest ending meeting is over before the current meeting starts, reuse the room (pop from heap).
# - Push the current meeting's end time to the heap.

# The size of the heap at the end represents the number of rooms needed.

# TC: O(n log n) - Sorting intervals and heap operations.
# SC: O(n) - Space for the heap.


import heapq
from typing import List


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[0])
        min_heap = []

        for interval in intervals:
            if min_heap and min_heap[0] <= interval[0]:
                heapq.heappop(min_heap)
            heapq.heappush(min_heap, interval[1])

        return len(min_heap)
