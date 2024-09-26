#Time complexity: O(NlogN)
#Space complexity: O(N)
import heapq as hq
class comparator:
    def __init__(self, start, end):
        self.start = start
        self.end = end
    
    def __lt__(self, other):
        return self.end < other.end
    
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        heap = []
        intervals.sort(key = lambda x:x[0])
        hq.heappush(heap, comparator(intervals[0][0], intervals[0][1]))
        
        for i in range(1, len(intervals)):
            meeting = intervals[i]
            if heap[0].end <= meeting[0]:
                hq.heappop(heap)
            hq.heappush(heap, comparator(meeting[0], meeting[1]))
        
        return len(heap)
