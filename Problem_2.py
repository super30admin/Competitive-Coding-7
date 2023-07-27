"""
Problem : 2

Time Complexity : O(nlogn)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Meeting Rooms II

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        # base
        if not intervals:
            return intervals
        # heap
        # sorting
        intervals.sort(key=lambda x:x[0])
        

        
        pq=[]
        heapq.heapify(pq)
        # iterating over array
        for i in range(len(intervals)):
            if not pq:
                heapq.heappush(pq,intervals[i][1])
            else:
                # start time vs end time
                if intervals[i][0]>=pq[0]:
                    heapq.heappop(pq)
                    heapq.heappush(pq,intervals[i][1])
                else:
                    heapq.heappush(pq,intervals[i][1])
        return len(pq)