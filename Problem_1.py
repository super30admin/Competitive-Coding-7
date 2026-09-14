# https://leetcode.com/problems/meeting-rooms-ii/

# Time complexity: O(n log n) 
# Space complexity: O(n)
# Explanation: Use a heap to keep track of meeting end times; if there is a start time that is greater than current min end time, then same meeting room can be used
# return size of heap to get min rooms possible

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals.sort()
        minheap = []
        heapq.heappush(minheap, intervals[0][1])
        for i in intervals[1:]:
            if minheap[0] <= i[0]:
                heapq.heappop(minheap)
            heapq.heappush(minheap, i[1])
        return len(minheap)
        
