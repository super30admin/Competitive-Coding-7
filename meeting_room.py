class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
            size = len(intervals)
            if size<=1: return size
            heap = []
            for interval in sorted(intervals):
                if heap and interval[0]>=heap[0]:
                    heapq.heappushpop(heap,interval[1])
                else:
                    heapq.heappush(heap,interval[1])
            return len(heap)

sol = Solution()
input = [[0,30],[10,50],[0,60]]
output = sol.minMeetingRooms(input)
print('Res: ',output)

