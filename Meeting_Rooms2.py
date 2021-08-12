#Time: O(nlogn)
#Space: O(n)
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals)<1:
            return 0
        intervals = sorted(intervals)
        heap = []
        heapq.heappush(heap,intervals[0][1])
        count = 1
        for i in range(1,len(intervals)):
            if intervals[i][0]<heap[0]:
                heapq.heappush(heap,intervals[i][1])
            count = max(count,len(heap))
        return count
        
        
        