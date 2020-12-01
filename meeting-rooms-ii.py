# Time Complexity: O(N Log N)
# Space Complexity: O(N)
# Approach: Use a minheap to keep track of the active meetings. For every new interval, pop out meetings from the heap which have ending time <= new interval's start time. Push the new interval in the heap. At any point, the number of elements in the heap is equal to the number of rooms required.
from heapq import *
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        start = 0
        end = 1
        intervals.sort()
        active_meetings = []
        rooms = 0
        
        for interval in intervals:
            while active_meetings and interval[start] >= active_meetings[0]:
                heappop(active_meetings)
            heappush(active_meetings, (interval[end]))
            rooms = max(rooms, len(active_meetings))
        return rooms
        