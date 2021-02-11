# Heaps
# TC: NlogN- when all meetings are during same time. 
# SC: O(N) 
# We store the end times in the heap, we start by appending the first meeting. When a new meeting is scheduled- we check if the end time of earliest(top of heap) to be completed meeting is completed or not. Id not append the end time of new meeting else pop the top element and append new one. Repeat this, at the end we return length of heap
import heapq
class Solution:
    def minMeetingRooms(self, intervals):
        if not intervals: return 0
        intervals.sort(key= lambda x:x[0])
        pq = []
        heapq.heappush(pq, intervals[0][1])
        for i in range(1, len(intervals)):
            if intervals[i][0] >= pq[0]:
                heapq.heappop(pq)
            heapq.heappush(pq, intervals[i][1])
        return len(pq)