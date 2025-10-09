"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
#Time complexity: O(nlogn) due to the sort that we have to do for the start and end array.
#Space complexity: O(2n) for taking start and end array so -> O(n)

# The intuition here is to sort the intervals array based on start and end time. And then use a if start time is less than the end time we can increment the rooms count.
# if thats not the case then decrement the room size by keeping track of the max rooms required for all the start and end meetings. 

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        room = 0
        maxRoom = 0
        if not intervals:
            return 0
        startArr = []
        endArr = []
        for interval in intervals:
            startArr.append(interval.start)
            endArr.append(interval.end)

        startArr.sort()
        endArr.sort()

        p1 = 0
        p2 = 0
        while (p1 < len(startArr) and p2 < len(endArr)):
            if startArr[p1] < endArr[p2]:
                room += 1
                maxRoom = max(maxRoom, room)
                p1 += 1
            else:
                room -= 1
                p2 += 1
        return maxRoom