#Time complexity is: O(nlogn)
#Space complexity is: O(n)
#Code ran successfully on leetcode
#No issues faced while coding

#Meeting room II

import heapq

class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def min_meeting_rooms(self, intervals) -> int:
        #Creating a priority queue and implementing heaps on top of them
        pq=[]
        for interval in intervals:
            #Defining the condition when to pop and insert values in the heap
            if(len(pq) and pq[len(pq)-1]<=interval[0]):
                heapq.heappop(pq)
            heapq.heappush(pq,interval[1])
        #Returning the length of the heap which are nothing but number of room required
        return len(pq)

o=Solution()
print(o.min_meeting_rooms([(0,30),(5,10),(15,20)]))