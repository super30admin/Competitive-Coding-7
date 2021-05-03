# Approach - Minheap
# TC - O(nlogn)
# SC - O(n)
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        intervals.sort(key = lambda x:x[0])
        #print(intervals)
        
        queue = []
        queue.append(intervals[0][1])
        
        for i in range(1, len(intervals)):
            if intervals[i][0] < queue[0]:
                heapq.heappush(queue, intervals[i][1])
            else:
                heapq.heappop(queue)
                heapq.heappush(queue, intervals[i][1])
                
        return len(queue)
                
               
                
            