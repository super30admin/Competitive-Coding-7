# https://leetcode.com/problems/meeting-rooms-ii/description/
# import heapq


# class Solution:
#     def minMeetingRooms(self, intervals):
#         intervals.sort()
#         pq = []
#         heapq.heappush(pq, intervals[0][1])
#         for i in range(1, len(intervals)):
#             if pq[0] <= intervals[i][0]:
#                 heapq.heappop(pq)
#             heapq.heappush(pq, intervals[i][1])

#         return len(pq)
    

class Solution:
    def minMeetingRooms(self, intervals):
        start = []
        end = []
        for s, e in intervals:
            start.append(s)
            end.append(e)
        start.sort()
        end.sort()
        i, j = 0, 0
        meetingRooms = 0
        while i < len(start):
            s, e = start[i], end[j]
            if s >= e:
                meetingRooms -= 1
                j += 1
            meetingRooms += 1
            i += 1

        return meetingRooms