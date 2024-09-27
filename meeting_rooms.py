# -*- coding: utf-8 -*-
"""
# Time: O(N log N) where N is the no. of elements in the given list
# Space: O(N) where N is the no. of elements in the given list, size of minheap
"""
from heapq import heappush, heappop

class Solution:
    def minMeetingRooms(self, intervals: [[]]) -> int:
        intervals.sort(key=lambda x: (x[0], x[1]))
        k = []
        mx = 0
        
        for st, end in intervals:
            while k and k[0] <= st:
                heappop(k)
            heappush(k, end)
            mx = max(len(k), mx)
			
        return mx

S = Solution()
print(S.minMeetingRooms([[0,30],[5,10],[15,20]]))