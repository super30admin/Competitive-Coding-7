# Time Complexity : O(N log N) N is number of meeting intervals
# Space Complexity : O(N) N is number of meeting intervals
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

def modifier(self, other):
    return self.end < other.end

Interval.__lt__ = modifier



import heapq as hq
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        # Write your code here
        heap = []
        rooms = 1
        intervals.sort(key = lambda x: (x.start, x.end))
        heap.append(intervals[0])
        hq.heapify(heap)
        for meeting in intervals[1:]:
            if heap[0].end <= meeting.start :
                hq.heappop(heap)
            else:
                rooms += 1
            hq.heappush(heap, meeting)
        return rooms