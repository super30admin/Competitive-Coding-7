from typing import List
from heapq import *

"""
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
find the minimum number of conference rooms required.

Eg: [[0, 30], [5, 10], [15, 20]]
Output : 2

Eg: [[7,10], [2,4]]
Output : 1

Approach:

When a room is taken, the room can not be used for another meeting until the current meeting is over.
As soon as the current meeting is finished, the room can be used for another meeting.
We can sort the meetings by start timestamps and sequentially assign each meeting to a room.
Each time when we assign a room for a meeting, we check if any meeting is finished so that the room can be reused.
In order to efficiently track the earliest ending meeting, we can use a min heap.
Whenever an old meeting ends before a new meeting starts, we reuse the room (i.e., do not add more room).
Otherwise, we need an extra room (i.e., add a room).
"""


class Solution:

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        """
            Time Complexity - O(nlogn)
                'n' is the number of intervals
            Space Complexity - O(n)
        """
        # edge case
        if not intervals:
            return -1

        # sort by start time
        intervals.sort(key=lambda x: x[0])

        # first meeting will always need one room
        # just add the first end time and increment room
        pq = [intervals[0][1]]
        room_count = 1

        # start from the second meeting
        for interval in range(1, len(intervals)):
            start_time, end_time = intervals[interval][0], intervals[interval][1]
            # start_time of current meeting > end_time of earlist available room
            # this means we can use the earliest available room for the current meeting
            if start_time >= pq[0]:
                heappop(pq)
            else:
                # cannot use existing room, add new room for the meeting
                room_count += 1
            # ending time of the current meeting
            heappush(pq, end_time)
        return room_count


if __name__ == '__main__':
    print(Solution().minMeetingRooms([[0, 30], [5, 10], [15, 20]]))
    print(Solution().minMeetingRooms([[2, 15], [36, 45], [9, 29], [16, 23], [4, 9]]))
    print(Solution().minMeetingRooms([[7, 10], [2, 4]]))
