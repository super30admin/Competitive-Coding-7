# https://neetcode.io/problems/meeting-schedule-ii/question

# This is a mock interview problem no. 7. The implementation for this is done using minheap
# The input array intervals first needs to be sorted

# TC: O(n log n) => sorting takes nlogn, then each insertion and deletion takes logn. n insertions and deletions becomes nlogn
# SC: O(n) => heap stores at most n end times

"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        minheap = []
        room_count = 0

        if not intervals:
            return 0

        intervals.sort(key=lambda x: x.start)
        
        first = intervals[0]
        heapq.heappush(minheap, first.end)
        room_count += 1

        for i in range(1, len(intervals)):
            
            pair = intervals[i]

            if pair.start >= minheap[0]:
                heapq.heappop(minheap)
                heapq.heappush(minheap, pair.end)
            else:
                room_count += 1
                heapq.heappush(minheap, pair.end)

        return room_count
    