# Time Complexity : O(n*log(n))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
import heapq


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class comparator:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        return self.end < other.end


class Solution:
    def min_meeting_rooms(self, intervals: list[Interval]) -> int:
        intervals.sort(key=lambda x: x.start)
        heap = []
        heapq.heappush(heap, comparator(intervals[0].start, intervals[0].end))
        for i in range(1, len(intervals)):
            meeting = intervals[i]
            if heap[0].end > meeting.start:
                heapq.heappush(heap, comparator(meeting.start, meeting.end))
            elif meeting.start >= heap[0].end:
                heapq.heappop(heap)
                heapq.heappush(heap, comparator(meeting.start, meeting.end))
        return len(heap)


check1 = Interval(7, 10)
check2 = Interval(12, 14)
check3 = Interval(15, 20)
print(Solution().min_meeting_rooms([check1, check2, check3]))
