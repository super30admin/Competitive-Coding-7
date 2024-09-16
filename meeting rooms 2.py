# TC: O(NlogN)
# SC: O(N)

class Solution:
    def minMeetingRooms(self, intervals) -> int:
        
        start = []
        end = []
        
        for i,j in intervals:
            start.append(i)
            end.append(j)
        start.sort()
        end.sort()
        
        room = 0
        e = 0
        s = 0
        while s<len(start):
            room += 1
            if start[s]>=end[e]:
                room -= 1 
                e += 1
            s += 1
        
        return room