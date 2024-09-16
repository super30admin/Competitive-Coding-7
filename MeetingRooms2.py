"""
// Time Complexity : O(n), 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals) #sort intervals according to starting time
        
        heap = []
        for i in range(len(intervals)):
            if i == 0:
                heapq.heappush(heap,intervals[i][1]) #for the first interval, add its ending time
            
            else:
                if intervals[i][0] < heap[0]: #if there is an overlap, push ending time to heap
                     heapq.heappush(heap,intervals[i][1])
                else:
                    heapq.heappop(heap) #else, remove the top element and add the ending time
                    heapq.heappush(heap,intervals[i][1])
                    
        return len(heap)