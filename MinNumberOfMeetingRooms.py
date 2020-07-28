-------------------------------- Min number of meeting rooms ---------------------------------------------
# Time Complexity : O(n log n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used heap to store the end time of the meeting and iterate through the array. 
#If my end time is less than the start time of any meeting, I will pop the end time from heap as it completed the meeting.
#and return the len(heap) once i iterated through the entire meetings array.

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        heap = []
        intervals.sort(key = lambda p:p[0])
        heapq.heappush(heap,intervals[0][1])
        for i in intervals[1:]:
            if heap[0]<=i[0]:
                heapq.heappop(heap)
            
            heapq.heappush(heap, i[1])
        return len(heap)
        
        
        