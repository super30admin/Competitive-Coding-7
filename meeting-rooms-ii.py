import heapq
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def minMeetingRooms(self, intervals):
        nums = heapq.heapify([])
        for interval in intervals:
            if nums and nums[-1] < interval[0]:
                nums.pop(0)
            nums.append(interval[1])
        return len(nums)