""""// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

import heapq
class customComparator:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        if self.end==other.end:
            return self.start < other.start
        return self.end < other.end

class Solution:
    def minMeetingRooms(self, intervals):
        h = []
        intervals.sort()
        count=0

        for i in range(len(intervals)):
            if len(h)!=0 and h[0].end <= intervals[i][0]:
                heapq.heappop(h)
                count-=1
            heapq.heappush(h, customComparator(intervals[i][0], intervals[i][1]))
            count+=1

        return count
Obj=Solution()
# print(Obj.minMeetingRooms([[0,2], [1,4], [3,10]]))
print(Obj.minMeetingRooms([[0,30], [5,10], [15,20]]))

