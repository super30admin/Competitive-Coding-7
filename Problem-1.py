#Approach
#Sort the intupt intervals based on the start time and for evry start time push the end time into heap next schedule if the end time is lee than the top add elsde pop the element and insert
#Finally no of elements in the heap is the no of classes


#Complexities
# Time: O(nlogn)
#Space O(n)

import heapq
from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort() #
        heap = []
        for interval in intervals:
            if len(heap)>0:
                min_end  = heapq.heappop(heap)
                if interval[0] >= min_end:
                    heapq.heappush(heap,interval[1])
                else:
                    heapq.heappush(heap,min_end)
                    heapq.heappush(heap,interval[1])
            else:
                heapq.heappush(heap,interval[1])
        return(len(heap))


s = Solution()
print(s.minMeetingRooms([[0,30],[5,10],[10,20]]))


