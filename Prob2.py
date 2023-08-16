# Time complexity : O(n * log(k))
# Space complexity : O(n)

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        heap=[]
        intervals.sort(key=lambda x:x[0]) #sort based on start time

        if len(intervals)>0:
            heapq.heappush(heap,intervals[0][1]) #add 1st meeting
        
        for i in range(1,len(intervals)):
            if heap and heap[0]>intervals[i][0]: #if top most end time is bigger than curr's start, add it (it can't be held currently, new room is needed)
                heapq.heappush(heap,intervals[i][1])
            elif heap:
                heapq.heappop(heap) #else, pop out top most meeting, and add curr's ending time
                heapq.heappush(heap,intervals[i][1])
        return len(heap)

        