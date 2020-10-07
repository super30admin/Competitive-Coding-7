# An array of meeting time intervals is given to you where every element consists of starting and ending time [[Start1,end1],[Start2,end2],...] (Starti < endi),you are required to find the minimum number of conference rooms required.
# For example,
# Given [[0, 30],[5, 10],[15, 20]],
# return 2.  
#####################################
# Solution - Using min heap and Sorting based on start times
# Time Complexity - O(NlogN) 
# Space Complexity - O(N) where  N is len(intervals)
import heapq
class Solution:
    def minMeetingRooms(self, intervals):
        count = 0
        if len(intervals) == 0:
            return 0
        # First we sort based on start times 
        newIntervals = sorted(intervals, key= lambda x:x[0])
        # Heap to the min end time everytime
        heap = []
        heapq.heappush(heap, newIntervals[0][1])
        count += 1
        for i in range(1,len(newIntervals)):
            if heap[0] <= newIntervals[i][0]:
                # if heap top is less than new interval start time 
                # then we will pop the top and push the new interval end time
                heapq.heappop(heap)      
            else:
                count += 1
            heapq.heappush(heap, newIntervals[i][1])
        return count