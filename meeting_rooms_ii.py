class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        min_heap = []

        intervals.sort(key=lambda x: x[0])

        for interval in intervals:
            if min_heap and interval[0] >= min_heap[0]:
                heapq.heappop(min_heap)
            heapq.heappush(min_heap, interval[1])

        return len(min_heap)


# time complexity is O(nlong)
# space complexity is O(n)
