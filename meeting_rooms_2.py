# O(N*LOG(N)) TIME AND O(N) SPACE

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        if len(intervals)==0:
            return 0
        meetingrooms=[intervals[0][1]]
        for interval in intervals[1:]:
            if interval[0]>=meetingrooms[0]:
                heapq.heappop(meetingrooms)
            heapq.heappush(meetingrooms,interval[1])
        return len(meetingrooms)