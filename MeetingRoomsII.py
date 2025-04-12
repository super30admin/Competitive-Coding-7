#Time Complexity : O(nlogn)
#Space Complexity : O(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = sorted([interval[0] for interval in intervals])
        end = sorted([interval[1] for interval in intervals])
        starting,ending = 0,0
        rooms,count = 0,0
        while(starting<len(start)):
            if(start[starting]<end[ending]):
                count+=1
                starting+=1
            else:
                count-=1
                ending+=1
            rooms = max(rooms,count)
        return rooms