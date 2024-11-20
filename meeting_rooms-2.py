# TC nlogn
# SC 0(n)


class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        R = []
        heapq.heapify(R)
        # count =0
        intervals.sort(key = lambda x:x[0])
        
        for i in intervals:
            if i:
                if len(R)==0:
                    heapq.heappush(R,i[1])
                else:
                    if R[0]>i[0]:
                        heapq.heappush(R,i[1])
                        # count+=1
                    else:
                        heapq.heappop(R)
                        heapq.heappush(R,i[1])
                        
        return len(R)
