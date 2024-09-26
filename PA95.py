#Time Complexity - O(nlogn)
#Space Complexity - O(n)
import heapq
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if not intervals:
            return 0
        intervals = sorted(intervals, key = lambda x : x[0])
        heap = []
        heapq.heappush(heap,intervals[0][1])
        for i in range(1,len(intervals)):
            if intervals[i][0] >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap,intervals[i][1])
        
        return len(heap)