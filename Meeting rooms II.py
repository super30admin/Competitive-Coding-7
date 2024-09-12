# TC : O(nlogn)
# # SC O(n)
import heapq as hq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # base case - check actual input data
        
        rooms  = []        
        if not intervals:
            return 0    
        intervals.sort()        
        hq.heappush(rooms, intervals[0][1]) 
        
        for i in intervals[1:]:
            if rooms[0] <= i[0]:
                hq.heappop(rooms)            
            hq.heappush(rooms, i[1])
        
        return len(rooms)