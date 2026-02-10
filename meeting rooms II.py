class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        heap=[]
        intervals.sort(key=lambda x:x[0])

        heapq.heappush(heap,intervals[0][1])

        for start, end in intervals[1:]:
            if start>=heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap,end)
        
        return len(heap)
            