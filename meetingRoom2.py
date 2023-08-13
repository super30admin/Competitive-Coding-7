from ast import List
import heapq


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        heap = []
        intervals.sort(key = lambda x: x[0])
      
        if len(intervals) > 0:
            heapq.heappush(heap, intervals[0][1])
        

        for i in range(1, len(intervals)):
            if heap and heap[0] > intervals[i][0]:
                heapq.heappush(heap, intervals[i][1])
            elif heap:
                heapq.heappop(heap)
                heapq.heappush(heap, intervals[i][1])

        return len(heap)

