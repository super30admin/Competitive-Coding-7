# Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

# Example 1:

# Input: intervals = [[0,30],[5,10],[15,20]]
# Output: 2
# Example 2:

# Input: intervals = [[7,10],[2,4]]
# Output: 1
 

# Constraints:

# 1 <= intervals.length <= 104
# 0 <= starti < endi <= 106

import heapq

class Solution:
    def minMeetingRooms(self, intervals) -> int:
        intervals.sort()
        endArr = []
        for start, end in intervals:
            if len(endArr):
                meetingEndTime = endArr[0]
                if  meetingEndTime <= start:
                    heapq.heappop(endArr)
                    
                heapq.heappush(endArr, end)
            else:
                heapq.heappush(endArr, end)
        return len(endArr)


sol = Solution()
print(sol.minMeetingRooms( [[26,29],[19,26],[19,28],[4,19],[4,25]]))