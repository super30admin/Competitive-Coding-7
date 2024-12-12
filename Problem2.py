class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        '''
        [[0,30],[5,10],[15,20]]
        
        heap = [30, 20]
        room = 2

        '''
        intervals = sorted(intervals, key=lambda x:x[0])
        heap = [intervals[0][1]]
        room = 1

        for st, end in intervals[1:]:
            # print(heap)
            top = heapq.heappop(heap)
            if st < top:
                room += 1
                heapq.heappush(heap, top)
                heapq.heappush(heap, end)
            
            else:
                heapq.heappush(heap, end)
                
        
        return room

            
            
