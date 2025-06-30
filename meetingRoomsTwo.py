"""
Sort the given intervals by start time
Use a min-heap to check the end times of meetings currently using rooms
Reuse a room if the current meeting starts after the earliest ended one
"""
""":
Time Complexity: O(n log n) - sorting + heap operations
Space Complexity: O(n) - heap stores at most all n meeting end times
"""

import heapq

class meetingRoomsTwo:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        if not intervals:
            return 0
        
        intervals.sort(key=lambda x: x[0])
        

        heap = []
        heapq.heappush(heap, intervals[0][1]) 

        for start, end in intervals[1:]:
            if start >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, end)
        
        return len(heap)
    
if __name__ == "__main__":
    obj = meetingRoomsTwo()

    intervals = [[0, 30], [5, 10], [15, 20]]
    print(obj.minMeetingRooms(intervals))

    intervals = [[7, 10], [2, 4]]
    print(obj.minMeetingRooms(intervals))

