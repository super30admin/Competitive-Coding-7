"""
Name: Srindihi
Did it run on LC: yes
Time Complexity: O((N) logN) - Creating heap for N element 
Space Complexity: O(N) - In worst case the entire input might be stored in the heap

Logic: Maintain a min-heap with the end time of each of the meetings and for every new incoming meeting
compare the start time of the incoming meeting and the end time of the previous meeting
2 cases arise, either new meeting room is needed, or the old meeting room can be utilised

Min heap with help us to kno which meeting ends first, hence that room can be occupied
"""
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0
        
        free_room = []
        
        intervals.sort(key = lambda x:x[0])
        
        heapq.heappush(free_room,intervals[0][1])
        
        for i in intervals[1:]:
            
            if free_room[0] <=i[0]:
                heapq.heappop(free_room)
            
            heapq.heappush(free_room,i[1])
        
        return len(free_room)