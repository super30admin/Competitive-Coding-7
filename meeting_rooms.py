# Approach:
# ----------
# 1. Sort the intervals based on start time.
# 2. Use a min-heap to track the end times of ongoing meetings.
# 3. For each interval:
#    - If the room due to free up (heap's top) is earlier than or equal to the current meeting's start,
#      that room can be reused (pop from heap).
#    - Push the current meeting's end time into the heap (allocate a room).
# 4. The size of the heap at the end is the minimum number of rooms required.

# Time Complexity: O(n log n)
# - Sorting: O(n log n)
# - Heap push/pop for each of n intervals: O(log n)
#
# Space Complexity: O(n) for heap storage in the worst case (all meetings overlap)

import heapq

class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

class Solution:
    def min_meeting_rooms(self, intervals):
        # Write your code here
        minHeap = [] # [ 20, 30]
        intervals.sort(key = lambda x: x.start) # [(0,30), (5,10), (15, 20)]
        for interval in intervals:
            if minHeap and minHeap[0] <= interval.start: # 10 <= 15
                heapq.heappop(minHeap) # minHeap = [30]
            heapq.heappush(minHeap, interval.end) # 30, 10, 20
        return len(minHeap)

# Main function to test the solution
def main():
    sol = Solution()

    print("Test Case 1:")
    intervals1 = [Interval(0, 30), Interval(5, 10), Interval(15, 20)]
    print("Min Rooms:", sol.min_meeting_rooms(intervals1))  # Expected: 2

    print("\nTest Case 2:")
    intervals2 = [Interval(7, 10), Interval(2, 4)]
    print("Min Rooms:", sol.min_meeting_rooms(intervals2))  # Expected: 1

    print("\nTest Case 3:")
    intervals3 = [Interval(1, 5), Interval(2, 6), Interval(3, 8), Interval(10, 15)]
    print("Min Rooms:", sol.min_meeting_rooms(intervals3))  # Expected: 3

    print("\nTest Case 4 (Empty):")
    intervals4 = []
    print("Min Rooms:", sol.min_meeting_rooms(intervals4))  # Expected: 0

if __name__ == "__main__":
    main()