"""
Leetcode: https://leetcode.com/problems/meeting-rooms-ii/

Approach:
    1. Sort the intervals based on start time.
    2. Push the first meeting end time in min heap.
    3. If the next meeting start time is greater than the root in min heap i.e. min heap has some meeting ending before the current meeting starts
    then pop the root and push the current end time
    4. At the end length of min heap will be the number of meeting rooms used for given intervals

Time Complexity: O(N log N) for sorting plus heap operation
Space Complexity: O(N) for heap
"""

from heapq import heappush as push
from heapq import heappop as pop


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:

        # base case - If there is no meeting to schedule then no room needs to be allocated.
        if not intervals:
            return 0

        # The heap initialization
        free_rooms = []

        # Sort the meetings in increasing order of their start time.
        intervals.sort(key=lambda x: x[0])

        # Add the first meeting. We have to give a new room to the first meeting.
        push(free_rooms, intervals[0][1])

        # For all the remaining meeting rooms
        for i in intervals[1:]:
            # end time in heap <= start time of interval
            if free_rooms[0] <= i[0]:
                pop(free_rooms)

            # for the existing room or the new room
            push(free_rooms, i[1])

        return len(free_rooms)
