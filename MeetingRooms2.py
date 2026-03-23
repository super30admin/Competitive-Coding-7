# Time Complexity : O(nlog(max-min))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, we sort all meetings by start time.
# We use a min-heap to track meetings by end time and remove any that have ended.
# The heap size at the end tells how many rooms we needed at max.

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x : x[0])

        pq = []
        heapq.heappush(pq, intervals[0][1])

        for i in intervals[1:]:
            if pq[0] <= i[0]:
                heapq.heappop(pq)

            heapq.heappush(pq, i[1])

        return len(pq)
        