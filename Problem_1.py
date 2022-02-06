# Time Complexity - O(len of intervals)
# Space Complexity - O(size of heap)

"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
import heapq
class Solution(object):
    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0
        heap = []
        intervals.sort(key= lambda x: x.start)
        heapq.heappush(heap, intervals[0].end)
        for i in intervals[1:len(intervals)]:
            #using Definition of intervals here 
            if heap[0] <= i.start:
                heapq.heappop(heap)
            heapq.heappush(heap, i.end)
        return len(heap)



