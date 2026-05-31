class Solution:
    def minMeetingRooms(self, intervals):
        startTimeArr = [interval[0] for interval in intervals]
        endTimeArr = [interval[1] for interval in intervals]

        startTimeArr.sort()
        endTimeArr.sort()

        currentRooms = 0
        res = 0
        i = 0
        j = 0

        while i < len(startTimeArr):
            if startTimeArr[i] < endTimeArr[j]:
                currentRooms += 1
                res = max(res, currentRooms)
                i += 1
            else:
                currentRooms -= 1
                j += 1

        return res

# Time: O(n log n)
# Space: O(n)