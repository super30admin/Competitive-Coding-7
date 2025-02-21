#Time Complexity = O(n logn)
# Space Complexity = O(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        # Separate start and end times, and sort them
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])
    
        res = count = 0
        s = e = 0
        # Iterate through start times
        while s < len(intervals):
            # If the next meeting starts before the earliest meeting ends
            if start[s] < end[e]:
                count += 1
                s += 1
            else:
                # Otherwise, free up a room
                count -= 1
                e += 1
            # Update the maximum number of rooms needed
            res = max(res, count)
        return res
