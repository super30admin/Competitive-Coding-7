'''
    Time Complexity:
        O(nlogn) (where n = number of intervals)

    Space Complexity:
        O(n) (where n = number of intervals)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Sort the intervals in ascending order of start times.
        Use MinHeap to put intervals (arranged by their end times).
            -> If the start time of this interval is greater than or equal to
                the room that gets emptied the earliest (top of the MinHeap):
                -> Pop that room from the heap.
            -> Push this interval to the heap.
        The length of the MinHeap at the end would be the number of rooms required.
'''

class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        return self.end < other.end


class Solution:
    def __init__(self):
        self.rooms = []
        self.intervals = []

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        self.build_objects(intervals)
        self.occupy_rooms()

        return len(self.rooms)

    def build_objects(self, intervals):
        for start, end in intervals:
            interval = Interval(start, end)
            self.intervals.append(interval)

    def occupy_rooms(self):
        for this_interval in self.intervals:
            if not self.rooms:
                heappush(self.rooms, this_interval)
                continue

            earliest_ending = self.rooms[0]

            if this_interval.start >= earliest_ending.end:
                heappop(self.rooms)

            heappush(self.rooms, this_interval)
