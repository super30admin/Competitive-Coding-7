import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        '''
        Approach 1
        Sort the intervals
        Compare the start of next meeting with end of previous
        If start of next is less than end of prev, then go to new room 
        else occupy same room 
        Time complexity: O(n log n)
        Space complexity: O(1)
        '''
        '''
        Approach 2
        Using min heap
        Sort the starting time of intervals 
        Add the end time of the first meeting 
        Compare the start time of next with the value in the root of the heap
        If start time is less than the previous end time then insert the end time of the current meeting
        else 
        update root
        Return the size of the min heap
        Time complexity: O(NlogN)
        Space complexity: O(N)

        '''
        if len(intervals) == 0 or intervals is None:
            return -1

        intervals.sort(key= lambda x:x[0])
        pq = []
        heapq.heappush(pq,intervals[0][1])
        for i in range(1,len(intervals)):
            if intervals[i][0] < pq[0]:
                heapq.heappush(pq,intervals[i][1])
            else:
                heapq.heapreplace(pq,intervals[i][1])
            
        return len(pq)




        