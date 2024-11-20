"""
Time Complexity : O(nlogn) where n is the no. of meetings
Space Complexity : O(n) where n is the no. of meetings
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        R = []
        heapq.heapify(R)
        # Sort the invertals in increasing order of start time
        intervals.sort(key = lambda x:x[0])
        # We use max heap as we have to minimize the meeting rooms so that we use less
        # space compared to min heap.
        for i in intervals:
            if i:
                if len(R)==0:
                    heapq.heappush(R,i[1])
                else:
                    if R[0]>i[0]:
                        heapq.heappush(R,i[1])
                        # count+=1
                    else:
                        heapq.heappop(R)
                        heapq.heappush(R,i[1])

        return len(R)