import heapq
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        #edge case
        if not intervals:
            return 0
        # sort by beggining
        intervals.sort(key = lambda x: x[0])
        #create a heap and put the end of the first interval in it
        heap = [intervals[0][1]]
        # loop through intervals from second interval
        for i in range(1,len(intervals)):
            #current is the interval you are processing now
            current = intervals[i]
            # if start of interval is more than end of the smallest end in heap
            if current[0] >= heap[0]:
                # pop from queue
                heapq.heappop(heap)
            # push always new end to heap
            heapq.heappush(heap,current[1])
        #return the length of the heap
        return len(heap)