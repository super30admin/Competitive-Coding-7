# Leetcode problem link : https://leetcode.com/problems/meeting-rooms-ii/
# Time Complexity:    O(NlogN) for sorting plus heap operation
# Space Complexity:   O(N) for heap
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Sort the intervals based on start time. Push the first meeting end time in min heap.
        If the next meeting start time is greater than the root in min heap i.e. min heap has some meeting ending before the current meeting starts then pop and push the current end time
        At the end length of min heap will be the number of meeting rooms required
'''
from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        # sort based on start time
        intervals.sort(key = lambda x:x[0])
        
        room_heap = []
        push(room_heap,intervals[0][1])
        
        for i in range(1,len(intervals)):
            
            if intervals[i][0] >= room_heap[0]:
                pop(room_heap)
            
            push(room_heap,intervals[i][1])
        
        return len(room_heap)
        
        
        
        