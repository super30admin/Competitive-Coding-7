"""

Approach = We will first sort all the intervals based on their start time and then 
we will make a min heap to store the end time of all the meetings and check it with the start time of the next meeting
if the end time is less than or equal to the start time of the next meeting, we will pop it from the heap, else keep pushing

Number of elements left in the heap in the end will be the number of rooms required
TC = O(nlogn)
SC = O(n)

"""
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if intervals is None:
            return 0
        rooms = []
        intervals.sort( key = lambda x:x[0])
        
        heapq.heappush(rooms,intervals[0][1])
        
        for m in intervals[1:]:
            if rooms[0]<= m[0]:
                heapq.heappop(rooms)
                
            heapq.heappush(rooms, m[1])
            
        return len(rooms)