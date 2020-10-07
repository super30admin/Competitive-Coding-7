# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if len(intervals) == 0:
            return 0
        if len(intervals) == 1:
            return 1
        
        #sort based on start time
        intervals.sort(key = lambda x:x[0])
        
        heap = []
        
        for itr in intervals:
            #check start time of the next meet with the end time of the previous meet
            if heap and itr[0] >= heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, itr[1])
            else:
                heapq.heappush(heap, itr[1])
        
        return len(heap)
