# Time Complexity : O(n log n) [n = length of the intervals list]
# Space Complexity : O(n) [n = length of the intervals list, heap extra space]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem approach
# 1. Sort the intervals by start time of the meeting
# 2. Now we need to check if we can use the same room for the meeting or not. 
#   2.1 In other words the start time of the next meeting must be greater than the end time of the any one meeting
#   2.2 The intervals are added in a min heap which is sorted by the end time. Thus the interval with the least meeting time is avilable at index 0

from heapq import heappush, heappop
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda key:key[0])
        heap = []
        for start, end in intervals:
            # Meeting with the least end time is present at index 0 of heap
            # If the meeting end time is less than the start time of curr interval
            # Pop from heap or in other words vacate the room for next meeting
            if heap and heap[0] <= start: 
                heappop(heap)
            heappush(heap, end) # Allocate the next available room
        return len(heap)