# T = O(n)
# S = O(logn)
# Approach:
# Sort the intervals based on the start time.
# For every interval in the sorted list see if the current element start time is grater than or equal to the
# previous interval that is stored in a mid heap if its true then pop the minheap else add that interval endtime
# in the heap. At the end of the iteration the length of the minheap will give the no of rooms needed.

from heapq import heappush as insert
from heapq import heappop as remove
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """

    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0
        heap = []
        intervals = sorted(intervals, key=lambda interval: interval.start)
        for i in intervals:
            if len(heap) == 0:
                insert(heap, i.end)
                continue
            if i.start >= heap[0]:
                remove(heap)
            insert(heap, i.end)
        return len(heap)

