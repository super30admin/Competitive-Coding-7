'''
Time: O(nlogn) + O(nlogk)
Space: O(n)
'''

import heapq as hq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key = lambda ele: ele[0])
        
        heap = list()
        hq.heappush(heap, intervals[0][1])
        
        for li in intervals[1:]:
            if heap[0] <= li[0]:
                hq.heappop(heap)
            hq.heappush(heap, li[1])
        
        return len(heap)