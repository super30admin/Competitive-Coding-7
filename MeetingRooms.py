"""

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.


Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Input: [[7,10],[2,4]]

Output:1

"""
#Time complexity O(NlogN) +O(NlogN) for sorting and min heap(priority queue)
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
import heapq
class Solution:  
    def minMeetingRooms(self, intervals):
        #intervals=sorted(intervals)
        intervals=sorted(intervals,key=lambda x:x[0])
        pq=[]
        for it in intervals:
            start,end=it[0],it[1]
            if(len(pq)>0 and pq[0]<=start):
                heapq.heappop(pq)
            heapq.heappush(pq,end)
        return len(pq)
    
obj=Solution()
intervals=[(0, 30),(5, 10),(15, 20),(18,29),(27,28),(32,35)]
room=obj.minMeetingRooms(intervals)
print(room)
    
        
        