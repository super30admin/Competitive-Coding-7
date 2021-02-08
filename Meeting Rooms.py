class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        #Approach: Min-heap
        #Time Complexity: O(n log n)
        #Space Complexity: O(n)
        #where, n is the number of meetings/given interval ranges
        
        rooms = 0
        if not intervals:
            return rooms
        
        intervals.sort()
        
        heap = []
        for meeting in intervals:
            if not heap or heap[0][0] > meeting[0]:
                rooms += 1
            else:
                heappop(heap)
            
            heappush(heap, (meeting[1], meeting))
        
        return rooms