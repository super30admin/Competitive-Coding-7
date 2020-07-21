class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(Klog(K)) [Where K is the length of intervals]
        Space: O(K) [The Heap Size]
    
    """
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        def sortFirst(val): 
             return val[0]
        
        if not intervals:
            return 0
        
        import heapq
        track = []
        count = 0
        
        intervals.sort(key = sortFirst)
        
        for i in intervals:
            if len(track) == 0:
                heapq.heappush(track, i[1])
            else:
                curr = track[0]
                if i[0] < curr:
                    heapq.heappush(track, i[1])
                else:
                    heapq.heappop(track)
                    heapq.heappush(track, i[1])
                
        return len(track)
                
            
            
            
            
            
        
