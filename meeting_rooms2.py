from heapq import heappop,heappush
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals)<=1:
            return len(intervals)
        
        
        heap=[]
        intervals.sort(key=lambda x:x[0])
        for i in range(len(intervals)):
            ele=intervals[i]
            if i==0:
                heappush(heap,ele[1])
            else:
                heapmin=heappop(heap)
                if heapmin>ele[0]:
                    heappush(heap,ele[1])
                    heappush(heap,heapmin)
                else:   
                    heappush(heap,ele[1])
        return len(heap)
       #Time O(nlogn)+O(nlogk), sorting time+iteration and heapify internal
       #space O(k), heap size max
