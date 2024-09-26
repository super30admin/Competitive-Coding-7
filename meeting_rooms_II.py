# Time: O(N log N)
# Space: O(N)

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # Base case
        if not intervals:
            return 0
            
        # free_Room act as heap
        free_Room = []
        
        # sort the intervals[0] start interval will be sorted
        intervals.sort(key = lambda x:x[0])
        
        # push into heap intervals[0][1]
        heapq.heappush(free_Room, intervals[0][1])
        
        # start from 1 since first interval is added into heap
        for i in intervals[1:]:
            if free_Room[0] <= i[0]:
                heapq.heappop(free_Room)
            # update everytime since it will be heapful to schedule a room for next time
            heapq.heappush(free_Room, i[1])
        
        return len(free_Room)
