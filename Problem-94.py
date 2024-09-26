#lintcode-ii - meetingroom-II - leetcode -253
#time complexity - O(N)
#space- O(1)
# Priority queue approach if the start time is less the peak element of priority queue then we push it elese we replace with the end time

"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

import heapq
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def minMeetingRooms(self, intervals):
        # Write your code here
        if not len(intervals): return 0
        intervals.sort(key=lambda x:x.start)
        pq=[]
       
        for i in intervals:
            if pq and i.start>=pq[0]:
                heapq.heapreplace(pq,i.end)
            else:
                heapq.heappush(pq,i.end)
        return len(pq)
                
