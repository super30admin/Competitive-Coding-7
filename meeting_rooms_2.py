# Time Complexity: O(n log n)
# Space Complexity: O(n)
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=itemgetter(0))
        
        h = []
        heapq.heapify(h)
        
        for meeting in intervals:
            if(len(h)==0):
                heappush(h, meeting[1])
            else:
                if(h[0]>meeting[0]):
                    heappush(h, meeting[1])
                else:
                    heappop(h)
                    heappush(h, meeting[1])
        return len(h)
        
        