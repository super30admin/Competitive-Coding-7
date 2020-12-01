#Time Complexity : O(nlogn)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        #sort input array by start time
        intervals.sort(key = lambda x : x[0])

        #initialise heap with end time of first meeting
        heap = [intervals[0][1]]

        for s, e in intervals[1:]:
            #if there is no overlap of meeting i.e. start time of next meeting is greater than end of previous meeting then we can pop out the earliest meeting in the heap as that room would be free
            if s >= heap[0]:
                heapq.heappop(heap)
            #add next meeting end time to heap
            heapq.heappush(heap, e)

        return len(heap)
