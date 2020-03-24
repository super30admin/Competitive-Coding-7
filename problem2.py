'''
Time Complexity: O(nlog n) -> n is number of intervals
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Use a min heap to keep track of the intervals of the timings. check if the current start time> least end time
if this is true, add the end time of the new timing into heap.
'''
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        rooms = []

        intervals.sort(key=lambda x: x[0])

        heapq.heappush(rooms, intervals[0][1])

        for i in intervals[1:]:

            if rooms[0] <= i[0]:
                heapq.heappop(rooms)

            heapq.heappush(rooms, i[1])

        return len(rooms)