import heapq
from typing import List

def minMeetingRooms(intervals):
    if not intervals:
        return 0
    
    # Sort the intervals by their start time
    intervals.sort(key=lambda x: x[0])
    #print(intervals)
    
    # Initialize a min-heap
    heap = []
    
    # Add the end time of the first meeting
    heapq.heappush(heap, intervals[0][1])
    print(heap)
    
    # Iterate over the remaining intervals
    for i in range(1, len(intervals)):
        # If the room due to free the earliest is free, remove it from the heap
        if intervals[i][0] >= heap[0]:
            heapq.heappop(heap)
        
        # Add the end time of the current meeting
        heapq.heappush(heap, intervals[i][1])
    
    # The size of the heap is the number of rooms required
    return len(heap)

# Example usage:
intervals = [[0, 30], [15, 20],[25,30],[5, 10], ]
print(minMeetingRooms(intervals))  # Output: 2

# Time Complexity: O(nlogn)
# Space Complexity: O(n)


