"""
Given an array of meeting time intervals intervals where 
intervals[i] = [starti, endi], return the minimum number of 
conference rooms required.

"""

# Time Complexity : O(mlogn)
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        intervals.sort(key=lambda x:x[0])
        print(intervals)
        
        freeRooms = []
        prevEnd = intervals[0][1]
        heapq.heappush(freeRooms, prevEnd)
        
        for inter in intervals[1:]:
            start = inter[0]
            end = inter[1]
            
            if freeRooms[0] <= start:
                heapq.heappop(freeRooms)
                
            heapq.heappush(freeRooms, end)
            
        return len(freeRooms)