"""
TC: O(N log N)
SC: O(N)
"""
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        minheap = [(intervals[0][1])]
        heapq.heapify(minheap)
        for curr in range(1, len(intervals)):
            curr_start = intervals[curr][0]
            curr_end = intervals[curr][1]
            # do comparison
            if curr_start >= minheap[0]:
                heapq.heappop(minheap)
            # add to heap
            heapq.heappush(minheap, curr_end)
        return len(minheap)


