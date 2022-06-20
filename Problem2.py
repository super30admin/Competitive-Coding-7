#Time Complexity: O(NlogN)
#Space Complexity: O(N)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key = lambda x: x[1])
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])

        first = 0
        second = 0
        count = 0
        res = 0
        while first < len(start):
            if start[first] < end[second]:
                first +=1
                count +=1
            else:
                second +=1
                count -=1
                
            res = max(res,count)
                
        return res