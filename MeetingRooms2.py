# Time Complexity : O(Nlogn)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Sort the intervals according to the starting time
# Initialize a heap with the first lists end time
# Iterate over the intervals list and check if the top element in heap is less than current interval end time
# If it is then pop the top element from the heap
# Then push the current interval end time into heap

import heapq


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return None
        intervals.sort()
        heap = []
        heapq.heappush(heap, intervals[0][1])
        for i in range(len(intervals)):
            if intervals[i][1] < heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, intervals[i][1])
        return len(heap)
