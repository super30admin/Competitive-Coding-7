class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        '''
        Time Complexity: O(nlogn)
        Space Complexity: O(k) where k is number of intervals
        '''
        intervals.sort(key=lambda x: x[0])
        # queue
        import heapq
        
        hp = []
        heapq.heappush(hp,intervals[0][1])
        
        for i in range(1,len(intervals)):
            k=0
            '''
            for j in range(0,len(o)):
                if(intervals[i][0]>=o[j]):
                    o[j] = intervals[i][1]
                    k=1
                    break
            '''
            if hp[0] <= intervals[i][0]:
                heapq.heappop(hp)
            
            heapq.heappush(hp,intervals[i][1])
        
        return len(hp)
