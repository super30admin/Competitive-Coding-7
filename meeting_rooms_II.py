class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        """
        TC : O(nlogn) + O(nlogn) =sorting start time + maintaining heap
        SC : O(n)
        """
        
        # sorting starting time
        intervals.sort()
        # create heap
        minHeap=[]
        for i in range(0, len(intervals)):
            # poppping if start time is greater than and equal to top element present in heap
            if  minHeap and intervals[i][0]>= minHeap[0] :
                heappop(minHeap)
            # pushing end time in heap
            heappush(minHeap, intervals[i][1])
        return len(minHeap)
            
    
# # same as above
# from heapq import heappush as push
# from heapq import heappop as pop

#     def minMeetingRooms(self, intervals: List[List[int]]) -> int:
#         intervals.sort()
#         end_heap=[]
#         push(end_heap, intervals[0][1])
#         for i in range(1, len(intervals)):
#             if intervals[i][0]>=end_heap[0]:
#                 pop(end_heap)
#             push(end_heap, intervals[i][1])
#         return len(end_heap)
            
            