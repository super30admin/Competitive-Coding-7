"""
253. Meeting Rooms II
Time Complexity - O(nlogn)
Space Complexity - O(n)
Sort intervals by first element
Then for first instance directly push end time in heap and increment room number by 1 if start value is less than top value push end value of second elemnt and increment room else if end value of top element is less than start of next interval push pop element
"""
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        heap = []
        rooms = 0
        for interval in intervals:
            if len(heap) == 0:
                heapq.heappush(heap,interval[1])
                rooms += 1
            else:
                if interval[0] < heap[0]:
                    heapq.heappush(heap,interval[1])
                    rooms += 1
                else:
                    heapq.heappushpop(heap,interval[1])
                    
        return rooms
                    
                    
        