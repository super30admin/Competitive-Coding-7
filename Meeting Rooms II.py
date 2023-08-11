from typing import (
    List,
)
from lintcode import (
    Interval,
)
from heapq import heappush, heappop, heapify
"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
# Time complexity : O(n)
# Space complexity : O(n) to maintain heap

# The code ran on Leetcode

# Maintain a heap to store all the distinct meetings rooms required. Pop elements from the min heap if the new new interval has start time > previous end time.
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key = lambda x:x.start)
        heap = []
        for interval in intervals:
            start = interval.start
            end = interval.end
            if heap and start >= heap[0]:
                heappop(heap)
                    
            heappush(heap, end)
        return len(heap)


