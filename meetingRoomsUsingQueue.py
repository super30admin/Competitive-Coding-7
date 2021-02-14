class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[0])
        # queue, worst case O(n^2)
        o = [intervals[0][1]]
        for i in range(1,len(intervals)):
            k=0
            for j in range(0,len(o)):
                if(intervals[i][0]>=o[j]):
                    o[j] = intervals[i][1]
                    k=1
                    break
            if(k==0):
                o.append(intervals[i][1])
        
        return len(o)
