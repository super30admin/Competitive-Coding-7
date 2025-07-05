# Time complexity: O(n log n)
# Space complexity: O(n)

import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        rooms = [intervals[0][1]]

        for start,end in intervals[1:]:
            if start >= rooms[0]:
                heapq.heappop(rooms)
            heapq.heappush(rooms,end)
        
        return len(rooms)

    
