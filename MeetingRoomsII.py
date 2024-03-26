'''
TC: O(nlogn) - where n is the number of intervals
SC: O(n)
'''
import heapq
from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=lambda x:x[0])
        heap = []
        for interval in intervals:
            if heap:
                if interval[0] >= heap[0][0]:
                    heapq.heappop(heap)
            heapq.heappush(heap, (interval[1],interval[0]))
        return len(heap)
s = Solution()
print(s.minMeetingRooms([[0,30],[5,10],[15,20]]))
print(s.minMeetingRooms([[7,10],[2,4]]))