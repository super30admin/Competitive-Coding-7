class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        heap=[intervals[0][1]]
        if len(intervals)==1:
            return 1
        for i in range(1,len(intervals)):
            start=intervals[i][0]
            end=intervals[i][1]

            if start<heap[0]:
                heapq.heappush(heap,end)
            else:
                heapq.heappop(heap)
                heapq.heappush(heap,end)
        
        return len(heap)

            
