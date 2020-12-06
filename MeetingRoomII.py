class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        intervals.sort()
        heap = []
        number = 0
        
        
        for a,b in intervals:
            if heap and heap[0]<=a:
                heapq.heappop(heap)
            heapq.heappush(heap, b)
            number = max(number, len(heap))
        return number
            
 Time: O(nlogn)
 Space: O(n)
