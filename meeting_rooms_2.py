# Time Complexity :
# O(N log N)

# Space Complexity :
# O(N)  

# Did this code successfully run on Leetcode :
#Yes

#We sort the interval arrays by the starting times. Then we start adding the end times to a heap - we are trying to find the earliest end time of a room to be free - so we use a min heap to store the end times. 
#We go through every interval in the list of intervals, and see if this new interval's start time is greater than the nearest finishing room, if it is not, then we need a new conference room, otherwise, the nearest ending conference room's end time is updated by the incoming interval's end time
#the number of unique elements in the heap at the end of this is the number of required rooms. 

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
