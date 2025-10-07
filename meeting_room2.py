import heapq
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key=lambda x: x[0])
        pq=[]
        
        for interval in intervals:
            if interval[0]<pq[0]:
                heapq.heappush(pq, interval[1])
            else:
                heapq.heappop(pq)
        return len(pq)
            
        
        
        
        
        
        Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2