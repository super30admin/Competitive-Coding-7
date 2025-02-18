import heapq
class Solution:
    # n - length of intervals, k- length of heap
    # TC : O(nlogk)
    # SC : O(k)
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if intervals is None:
            return 0
        intervals.sort()
        print(intervals)
        heap = []
        for i in intervals:
            s,e = i[0],i[1]
            if len(heap)>0 and heap[0] <= s:
                heapq.heappop(heap)
            heapq.heappush(heap,e)
        return len(heap)