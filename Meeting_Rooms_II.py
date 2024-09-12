import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        #print(intervals[0][1])
        interval = sorted(intervals)
        #print(interval)
        heap = []
        
        heappush(heap,interval[0][1])
        for i in range(1,len(interval)):
            smallest_endtime = heapq.nsmallest(2,heap)
            if smallest_endtime[0] <= interval[i][0]:
                heappop(heap)
                heappush(heap, interval[i][1])
                #heapq.heapify(heap)
            
            else:
                heappush(heap, interval[i][1])
                
            
        return len(heap)        
        
        
        
        
        
