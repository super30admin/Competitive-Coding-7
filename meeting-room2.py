# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq
from typing import List


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:

        intervals.sort()  # sorting based on the start time of the intervals
        meet_rooms = 1  # 1 room is obviously needed
        heap = [intervals[0][1]]  # storing the end time of meetings

        # iterating through start and end time staring from 1st interval
        for start, end in intervals[1:]:
            # if prev end time of meeting is less than or equal to current start time
            if heap[0] <= start:

                # no overlap, make a slot available in the current room
                heapq.heappop(heap)

            # if overlap, add new room
            heapq.heappush(heap, end)

            # update meeting rooms
            meet_rooms = max(meet_rooms, len(heap))

        return meet_rooms
