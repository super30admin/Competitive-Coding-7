# TC: O(nlogn + nlogn)
# SC: O(n)

from heapq import heappush
from heapq import heappop

class Solution:
    
    class interval:
        def __init__(self, start, end):
            self.start = start
            self.end = end
        def __lt__(self, other):
            return self.end < other.end

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        intervals = sorted(intervals, key = lambda x:x[0])
        q = []
        rooms = 0
        
        for slot in intervals:
            #print(q)
            s, e = slot
            if not q:
                heappush(q, self.interval(s,e))
                rooms += 1
                continue
            top = q[0]
            
            # incompatible
            if s < top.end:
                heappush(q, self.interval(s,e))
                rooms += 1
            else:
                heappop(q)
                heappush(q, self.interval(s,e))
        
        return rooms