# Time Complexity: O(nlog(n))
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The minimum number of meeting rooms required is gotten by sorting the meetings by the start time first and then iterating through them. 
If a meeting is to start after the earliest meeting ends, then we can use the same room, otherwise we need a new room. We keep track of 
the rooms in a minheap and pop the earliest meeting end time if the next meeting start time is after it. We then push the new meeting 
end time onto the heap.
"""

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: x[0])
        rooms = [intervals[0][1]]
      
        for i in range(1, len(intervals)):
            meeting = intervals[i]

            if meeting[0] >= rooms[0]: heapq.heappop(rooms)
            heapq.heappush(rooms, meeting[1])
        
        return len(rooms)