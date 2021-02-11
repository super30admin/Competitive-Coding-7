import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0
        intervals.sort()
        my_heap = [intervals[0][1]]
        heapq.heapify(my_heap)

        for i in range(1,len(intervals)):
            curr_start, curr_end = intervals[i]
            if curr_start >= my_heap[0]:
                heapq.heappop(my_heap)
            heapq.heappush(my_heap, curr_end)
        return len(my_heap)