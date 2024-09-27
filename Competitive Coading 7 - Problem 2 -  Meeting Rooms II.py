"""
FAANMG Problem #97 {Medium} 

253. Meeting Rooms II


Time Complexity O(nlogk)
Space Complexity:  O(n)
        
Did this code successfully run on Leetcode : Yes

Heap Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # create a min heap
        minHeap = []

        # sort the list according to the start time of the meeting
        intervals.sort(key = lambda x : x[0])

        # we insert the first meeting into the minHeap. We insert the end time here
        heapq.heappush(minHeap, intervals[0][1])

        # we keep on inserting into heap only if the start time of the first element is greater than the end time of another meeting
        for i in range(1,len(intervals)):
            if minHeap[0] <= intervals[i][0]:
                # if any meeting is over, then we remove it
                heapq.heappop(minHeap)
            heapq.heappush(minHeap, intervals[i][1])
        # res is the length of the minHeap 
        return len(minHeap)