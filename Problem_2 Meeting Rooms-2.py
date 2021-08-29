# // Time Complexity : O(nlogn)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        free_room =[]
        intervals.sort(key = lambda x:x[0])
        heapq.heappush(free_room, intervals[0][1])
        for i in intervals[1:]:
            if free_room[0] <=i[0]:
                heapq.heappop(free_room)
            heapq.heappush(free_room, i[1])
        return len(free_room)