import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0 
        intervals.sort(key = lambda x:x[0])
        arr = []
        rooms = 1
        arr.append(intervals[0][1])
        heapq.heapify(arr)
        for i in intervals[1:]:
            if arr[0] > i[0]:
                rooms += 1
            else:
                heapq.heappop(arr)
            heapq.heappush(arr,i[1])
        return rooms