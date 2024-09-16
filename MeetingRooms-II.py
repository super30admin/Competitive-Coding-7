# TC: O(N logN) where N is the size of the time intervals given, as we iterate over all of them and also sort them, so N logN. And logN for heapify() that e perform.
# SC: O(N) where N will be size of the size of the heap, that is the number of meeting rooms being returned. 

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        
        heap = []
        
        for start,end in intervals: 
            if len(heap) == 0: 
                heapq.heappush(heap, start)
            
            curr = heap[0]
            
            if curr <= start: 
                heapq.heappushpop(heap, end)
            else: 
                heapq.heappush(heap, end)
        
        return len(heap)
                
