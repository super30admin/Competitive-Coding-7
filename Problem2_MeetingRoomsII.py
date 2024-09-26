# Time Complexity: O(n logn), where n - length of the intervals
# Space Complexity: O(n)

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals or len(intervals) == 0:
            return 0

        # Sort the intervals based on the start time
        intervals.sort(key=lambda x: x[0])

        # Store the end time of intervals in a Heap
        heap = []
        heapq.heappush(heap, intervals[0][1])

        # Compare the start time of every interval with the minimum end time (peek val)
        for i in range(1, len(intervals)):
            start = intervals[i][0]
            end = intervals[i][1]

            # Use the same room if it starts later the minimum end time, else add a new room
            if start >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, end)

        return len(heap)

