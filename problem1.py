# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

from collections import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x:x[0])
        min_heap = []

        for start,end in intervals:
            if len(min_heap) == 0:
                heapq.heappush(min_heap, end)
                continue
            earliest_end = min_heap[0]
            if start >= earliest_end:
                heapq.heappop(min_heap)
                heapq.heappush(min_heap, end)
            else:
                heapq.heappush(min_heap, end)
        
        return len(min_heap)