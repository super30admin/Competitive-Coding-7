import heapq
class Solution:
    def minMeetingRooms(self, start, end):
        
        h = []
        
        intervals = sorted(zip(start, end))
        
        for start, end in intervals:
            if len(h) == 0: 
                heapq.heappush(h, (end, start))
                continue
            
            top_end, top_start = h[0]
            if start < top_end: 
                heapq.heappush(h, (end, start))
            else: 
                heapq.heapreplace(h, (end, start)) # or we can pop and push, its the same
                
            
        return len(h)
    
