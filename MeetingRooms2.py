# Time Complexity : O(n)
# Space Complexity : O(n)

from heapq import heapify, heappush as push,heappop as pop

class Solution:
    def sortFirst(self,val):
        return val[0]
    def minMeetingRooms(self,intervals):
        intervals.sort(key=self.sortFirst)
        count = 0
        arr = []
        heapify(arr)
        for interval in intervals:

            if len(arr) == 0:
                count += 1
                push(interval[1])
            else:
                if interval[0] >= arr[0]:
                    pop(arr)
                else:
                    count += 1
                push(interval[1])
        return count