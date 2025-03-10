# Time Complexity : O(nlogn) - n is number of intervals
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Sort the intervals by start time of the meeting
Maintain a min heap and push the end time of the first meeting to heap

Loop through the sorted intervals array, if start of interval > min end time in heap,
remove the end time (meeting room is free)

And add the end time of the current interval to the min heap

Size of the heap would be the number of meeting rooms required

"""
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """

        sorted_intervals = sorted(intervals, key=lambda x: x[0])

        if len(sorted_intervals) == 0:
            return 0

        rooms = []
        heapq.heappush(rooms, sorted_intervals[0][1])

        for i in range(1,len(sorted_intervals)):
            if rooms[0] <= sorted_intervals[i][0]:
                heapq.heappop(rooms)
            heapq.heappush(rooms, sorted_intervals[i][1])
        return len(rooms)


