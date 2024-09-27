# Time Complexity : O(nlogn) : n- no.of elements
# Space Complexity: O(n)
# Approach : Sort the intervals according to their start time and then add elements to min-heap and every check the first element of heap and current interval.
#            The size of the heap is the min meeting rooms.

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        #intervals = [[0,30],[5,10],[15,20]]
        intervals.sort(key = lambda x:x[0])
        heap = [] 
        heapq.heappush(heap,intervals[0][1])
        
        for i in range(1,len(intervals)):
            if intervals[i][0] >= heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap,intervals[i][1])
            else:
                heapq.heappush(heap,intervals[i][1])
                
        return len(heap)

        