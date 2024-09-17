class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0 or len(intervals[0]) == 0: return -1
        start = []
        end = []
        for meeting in intervals:
            start.append(meeting[0])
            end.append(meeting[1])
        start.sort()
        end.sort()
        s = e = 0
        numRooms = available = 0

        while s < len(start):
            if start[s] < end[e]:
                if available > 0:
                    available -= 1
                else:
                    numRooms += 1

                s += 1


            else:
                available += 1
                e += 1
        return numRooms
