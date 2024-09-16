"""
Time Complexity : O(nlogn)- 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We will be using min heap here. For evey interval, we are going to check end time of previous interval, ie
minimum on top of heap.if it is smaller than current start time, that means we can reuse the meeting room. 
So we will pop out smallest and push in the current end time. If the previous end time is more than current 
start time, then we definitely need a new room, so we will push in the current end time inside heap.
At the end, length of heap would be our number of rooms required.
"""

"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""




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
