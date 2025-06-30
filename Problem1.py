"""
I used a min-heap to track meeting end times. After sorting the intervals by start time, I pushed the first meeting's end into the heap. For each meeting, if it starts after or at the earliest end time, I reuse the room by popping from the heap. The final heap size gives the minimum number of rooms needed.
Time Complexity: O(n log n)
Space Complexity: O(n)
"""
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda i : i[0])
        heap = []
        heapq.heappush(heap, intervals[0][1])
        for start, end in intervals[1:]:
            if start >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, end)
        return len(heap)