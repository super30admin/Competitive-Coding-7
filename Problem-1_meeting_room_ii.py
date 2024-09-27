# APPROACH 1: OPTIMAL 
# Time Complexity : O(n), n: len(intervals)
# Space Complexity : O(n), size of min_heap, in worst case, if all the meetings happen in the same interval
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Sort the meetings according to start time.
# 2. For each meeting, check if it's start time is greater than the end time of the meeting at root of min_heap (this represents the earliest finishing meeting till now).
#     If so, we can use this same room, so delete the root and add the end time of this new meeting to min_heap.
# 3. If it's start time is less than the end time of the meeting at root of min_heap - means this new meeting will start before the earliest meeting finishes, then we need a new 
#    room. So add the end time of this meeting to min heap.


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        if intervals is None:
            return None
        
        if len(intervals) <= 0:
            return 0
        
        intervals.sort()
        min_heap = [intervals[0][1]]
        
        for ind in range(1, len(intervals)):
            start, end = intervals[ind]
            
            if start >= min_heap[0]:
                heapq.heappop(min_heap)
                
            heapq.heappush(min_heap, end)
                
        return len(min_heap)
