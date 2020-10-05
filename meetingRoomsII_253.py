# https://leetcode.com/problems/meeting-rooms-ii/

# // Time Complexity : O(N logN)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Your approach:
#sort intervals based on starting time
#we only need to take care that the start time of meeting is greater than end time of previous meeting: if it isn't -> add another meeting room otherwise replace the end time of meeting room in the minheap that maintains end times of meetings

import heapq as hq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        if not intervals:
            return 0
        
        heap=[]
        intervals.sort()
        
        hq.heappush(heap, intervals[0][1])
        
        for i in intervals[1:]:
            if heap[0]<=i[0]:
                hq.heappop(heap)
            hq.heappush(heap, i[1])
            
        return len(heap)