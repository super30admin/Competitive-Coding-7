#Time Complexity: O(nlogn) + O(nlogk)
#Space Complexity: O(n)
from typing import (
    List,
)
from lintcode import (
    Interval,
)

"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

import heapq as hq
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        # Write your code here
        intervals.sort(key = lambda x:x.start)
        heap = []
        hq.heappush(heap,intervals[0].end)

        for lst in intervals[1:]:
            if heap[0]<= lst.start:
                hq.heappop(heap)
            hq.heappush(heap,lst.end)
        return len(heap)
