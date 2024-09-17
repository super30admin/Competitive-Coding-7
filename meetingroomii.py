
"""#metting room ii
Time complexity : O(nlogn)
Space Complexity: (O(n))
"""
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
       # sort with start time
        intervals.sort()
        heap = []
        heapq.heappush(heap,intervals[0][1])
        count =1
        for interval in intervals[1:]:
            end = heap[0]
            if end<=interval[0]:
                heapq.heappop(heap)
                count-=1
            heapq.heappush(heap,interval[1])
            count+=1
        return count
        