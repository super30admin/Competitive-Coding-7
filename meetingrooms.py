class Solution:
    
    """
    Description: Given an array of meeting time intervals intervals, return the minimum number of conference rooms
    
    Time Complexity: O(n log n)
    Space Complexity: O(n)
    
    Approach:
    - maintain a heap with end time of first meeting
    - for remaining meetings, pop the elemenet when start time of next meeting is above end time of the first meeting
    - otherwise push in heap
    - return size of the heap
    """
    
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        from heapq import heappush, heappop

        if len(intervals) == 0: return 0
        heap = []

        sorted_timings = sorted(intervals)
        heappush(heap, sorted_timings[0][1])
        __, endtime = sorted_timings[0]

        for times in sorted_timings[1:]:
            strtime = times[0]
            if strtime >= heap[0]:
                heappop(heap)
            heappush(heap, times[1])

        return len(heap)
