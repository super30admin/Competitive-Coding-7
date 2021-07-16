# [[0,30],[5,10][15,20]]
import heapq
class Solution:
    def minMeetingRooms(self, intervals) -> int:
        intervals.sort(key=lambda x: x[0])
        q=[]
        heapq.heappush(q, intervals[0][1])
        count=1
        for i in range(1, len(intervals)):
            print(intervals[i][0],q[0])
            if q and intervals[i][0]>q[0]:
                print(intervals[i][0])
                heapq.heappop(q)
                heapq.heappush(q, intervals[i][1])
            else:
                heapq.heappush(q, intervals[i][1])
                count+=1
        return count
sol=Solution()
print(sol.minMeetingRooms([[0,30],[5,32],[15,20],[6,9]]))