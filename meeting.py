# Time Complexity: O(n log n)
# Space Complexity: O(n) 
import heapq
class Solution:

    # If there is no meeting we wont be assigning any room
    # but if there are then we will sort based on the end time of the meeting as that
    # meeting room will be available early for next meetings and we will
    # push all the end time of the meeting sorted in heap with key as end time of the meetings
    # then we will iterate over the meetings from 2 nd as we definitely need to assign 1 room to the first meeting
    # Then we will check if the current meeting in heap having less than or equal to value as the
    # start of the current meeting while iterating and if so then we will pop from heap as we can use that meeting room.

    #  We will push the current meeting end time in the heap 
    #  whether we are using new room or using old ones
    # After the iteration we the size of the heap will be the required meeting rooms of conference.
    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0

        heapm = []

        intervals.sort(key=lambda y: y[0])

        heapq.heappush(heapm, intervals[0][1])

        for i in intervals[1:]:

            if heapm[0] <= i[0]:
                heapq.heappop(heapm)


            heapq.heappush(heapm, i[1])


        return len(heapm)   