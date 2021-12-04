# 253. Meeting Rooms II
# https://leetcode.com/problems/meeting-rooms-ii/

# Logic: Sort the input on the start time. Create a min heap of end time, 
# because we need to see if the last meeting has ended or not when the 
# new meeting comes. If the min end time is more tha new start time just 
# add the new meeting in the heap, else, remove the min end time. Return 
# the len of the heap.

# Time Complexity: O(nlogn) [sorting the input]
# Space Complesxity: O(n)

import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        meeting_rooms = list()
        
        intervals.sort(key = lambda x: (x[0]))
        
        heapq.heappush(meeting_rooms, intervals[0][1])
        
        for i in intervals[1:]:
            if i[0] >= meeting_rooms[0]:
                heapq.heappop(meeting_rooms)
            heapq.heappush(meeting_rooms, i[1])
        
        return len(meeting_rooms)