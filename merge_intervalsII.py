#Time Complexity: O(nlogn)
#Space Complexity: O(n)
import heapq
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        #sort the intervals based on Start times
        intervals.sort(key=lambda x: x[0])
        min_heap = []
        for each_meeting in intervals:
            if min_heap:
                current_min_end_time = min_heap[0]
                if each_meeting[0] <= current_min_end_time:
                    heapq.heappush(min_heap,each_meeting[1])

                else:
                    heapq.heappop(min_heap)
                    heapq.heappush(min_heap,each_meeting[1])      
            else:
                heapq.heappush(min_heap,each_meeting) 
        
        return len(min_heap)
            

        