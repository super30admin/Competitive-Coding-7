# Time Complexity : O(n*log(n)), where n is the number of intervals given
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# This approach sorts the intervals based on the starting time
# of each meeting. if a meetings start time is after the prev
# meetings end time, extra room is not needed, otherwise needed
import heapq
class Solution(object):
    def findMinNoOfMeetingRooms(self, intervals):
        if not intervals:
            return 0
        # sort based on start time
        intervals.sort(key=lambda x: x[0])
        pq = []
        # Add First finish time
        heapq.heappush(pq, intervals[0][1])

        for i in range(1, len(intervals)):
            # If start time > prev meetings end time,
            # Do not need an extra meeting room
            if intervals[i][0] >= pq[0]:
                heapq.heappop(pq)

            heapq.heappush(pq, intervals[i][1])

        return len(pq)


print Solution().findMinNoOfMeetingRooms([[0,30], [15,20], [5, 10]])  # 2
print Solution().findMinNoOfMeetingRooms([[0, 30], [5, 10], [0, 20], [20, 40], [0, 5]])  # 3
