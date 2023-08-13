# Time Complexity :O(N log N)
# Space Complexity :O(N)  
# Did this code successfully run on Leetcode :Yes 
from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        self.heap = []
        intervals.sort(key=lambda x: int(x[0]))

        for interval in intervals:
            if len(self.heap) != 0  and self.heap[0] <= interval[0] :
                remove(self.heap)
            insert(self.heap,interval[1])

        return len(self.heap)