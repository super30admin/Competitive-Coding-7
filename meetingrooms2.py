# Time Complexity : O(N log N) where N is the number of intervals
# Space Complexity : O(N) where N is the number of intervals
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am sorting the intervals based on the start time.
# I am using a min heap to keep track of the end times of the meetings.
# For each interval, if the start time is greater than or equal to the minimum end time in the heap, I am replacing the minimum end time with the current end time.
# If not, I am adding the current end time to the heap.
# The size of the heap at the end will give the number of meeting rooms required.

from typing import List
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0 :
            return -1
        intervals.sort(key=lambda x:x[0])
        minHeap = []
        for start,end in intervals:
            if minHeap and start >= minHeap[0]:
                heapq.heapreplace(minHeap,end)
            else:
                heapq.heappush(minHeap,end)
        return len(minHeap)
        