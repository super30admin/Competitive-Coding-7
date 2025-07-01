# ----------------------------------------------------
# Intuition:
# We want to find the minimum number of conference rooms to schedule all meetings.
#
# 1) Brute Force:
#    Maintain a list of rooms with their current meeting end times.
#    For each meeting, check if any room is free before the meeting starts.
#    If a room is free, assign the meeting to that room by updating its end time.
#    Otherwise, allocate a new room.
#    This approach has O(n^2) time complexity due to checking all rooms for each meeting.
#
# 2) Heap-Based Optimized:
#    Sort meetings by start time.
#    Use a min-heap to track the earliest ending meeting.
#    For each meeting, if it starts after the earliest ending meeting ends, reuse that room (pop from heap).
#    Push the current meeting's end time into the heap.
#    The heap size at any time equals the number of rooms required.
#    This approach runs in O(n log n) time.
#
# 3) Line Sweep / Two Pointers:
#    Extract and sort all start times and end times separately.
#    Iterate through start times, and compare each with the earliest end time.
#    If a meeting starts after or at the earliest end time, move the pointer forward to reuse the room.
#    Otherwise, allocate a new room.
#    The total number of allocated rooms is the answer.
#    This also runs in O(n log n) time.
# ----------------------------------------------------

# ----------------------------------------------------
# Time Complexity: O(n log n)
# - Sorting intervals or start/end arrays: O(n log n)
# - Heap operations or linear passes: O(n log n) or O(n)
#
# Space Complexity: O(n)
# - Heap or arrays to track room end times or start/end times
# ----------------------------------------------------

from typing import List
import heapq


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        intervals.sort(key=lambda x: x[0])
        heap = []

        for start, end in intervals:
            if heap and heap[0] <= start:
                heapq.heappop(heap)
            heapq.heappush(heap, end)

        return len(heap)


# ----------------------------------------------------
# Line Sweep / Two Pointers Approach

# Time Complexity: O(n log n)
# - Sorting start and end times: O(n log n)
# - Single pass with two pointers: O(n)
#
# Space Complexity: O(n)
# - Separate arrays for start and end times

# class SolutionLineSweep:
#     def minMeetingRooms(self, intervals: List[List[int]]) -> int:
#         if not intervals:
#             return 0

#         starts = []
#         ends = []

#         for interval in intervals:
#             starts.append(interval[0])
#             ends.append(interval[1])

#         starts.sort()
#         ends.sort()

#         rooms = 0
#         earliest_end_index = 0

#         for i in range(len(starts)):
#             if starts[i] >= ends[earliest_end_index]:
#                 earliest_end_index += 1
#             else:
#                 rooms += 1

#         return rooms


# ----------------------------------------------------
# Brute Force Approach (Naive)

# Time Complexity: O(n^2)
# - Sort intervals: O(n log n)
# - For each meeting, scan all rooms linearly: O(n)
#
# Space Complexity: O(n)
# - Store end times of rooms

# class SolutionBruteForce:
#     def minMeetingRooms(self, intervals: List[List[int]]) -> int:
#         if not intervals:
#             return 0

#         intervals.sort(key=lambda x: x[0])
#         rooms = []

#         for start, end in intervals:
#             assigned = False
#             for i in range(len(rooms)):
#                 if rooms[i] <= start:
#                     rooms[i] = end
#                     assigned = True
#                     break
#             if not assigned:
#                 rooms.append(end)

#         return len(rooms)



# ----------------------------------------------------
# Example test cases for manual testing
# ----------------------------------------------------
if __name__ == "__main__":
    sol = Solution()

    intervals1 = [[0,30],[5,10],[15,20]]
    print("Input:", intervals1)
    print("Output:", sol.minMeetingRooms(intervals1))  # Expected: 2
    print("-" * 30)

    intervals2 = [[7,10],[2,4]]
    print("Input:", intervals2)
    print("Output:", sol.minMeetingRooms(intervals2))  # Expected: 1
    print("-" * 30)

    intervals3 = [[1,5],[8,9],[8,9]]
    print("Input:", intervals3)
    print("Output:", sol.minMeetingRooms(intervals3))  # Expected: 2
    print("-" * 30)

    intervals4 = [[13,15],[1,13]]
    print("Input:", intervals4)
    print("Output:", sol.minMeetingRooms(intervals4))  # Expected: 1
    print("-" * 30)

    intervals5 = [[6,15],[13,20],[6,17]]
    print("Input:", intervals5)
    print("Output:", sol.minMeetingRooms(intervals5))  # Expected: 3
    print("-" * 30)

