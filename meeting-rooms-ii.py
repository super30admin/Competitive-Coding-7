'''
TC: O(nlogn)
SC: O(n)
'''
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if not intervals:
            return 0
        
        sintervals = sorted(intervals, key = lambda k:k[0])
        
        eheap = list()
        
        heapq.heapify(eheap)
        heapq.heappush(eheap, (sintervals[0][1], sintervals[0][0]))
        
        for i in range(1, len(intervals)):
            top = eheap[0]
            if sintervals[i][0] >= top[0]:
                heapq.heappushpop(eheap, (sintervals[i][1], sintervals[i][0]))
            else:
                heapq.heappush(eheap, (sintervals[i][1], sintervals[i][0]))
        
        return len(eheap)