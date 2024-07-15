# Time Complexity : O(nlogn)
# Space Complexity : O(n)

from collections import defaultdict

class MeetingRoomsII:
    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0

        timeline = defaultdict(int)
        room_count = 0
        cur = 0

        for interval in intervals:
            start, end = interval
            timeline[start] += 1
            timeline[end] -= 1

        for time in sorted(timeline.keys()):
            cur += timeline[time]
            room_count = max(room_count, cur)

        return room_count

# Examples
solution = MeetingRoomsII()

intervals1 = [[0, 30], [5, 10], [15, 20]]
intervals2 = [[7, 10], [2, 4]]
intervals3 = [[1, 5], [2, 6], [8, 9], [8, 9]]

print(solution.minMeetingRooms(intervals1)) # Output: 2
print(solution.minMeetingRooms(intervals2)) # Output: 1
print(solution.minMeetingRooms(intervals3)) # Output: 2