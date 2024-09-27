#Problem 2: https://leetcode.com/problems/meeting-rooms-ii/
#Time Complexity:    O(n.logn)
#Space Complexity:   O(n)
#Approach- low-0th element , high=last element, find mid ,perform Binary Search by computing number of elements less than mid, moving low and high
#pointers accordingly.
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
       #edge case
        if not intervals:
            return 0
        #put start and end timings in different array
        start_timing=[]
        end_timing=[]
        for i in range(len(intervals)):
            start_timing.append(intervals[i][0])
        for i in range(len(intervals)):
            end_timing.append(intervals[i][1])
        
        #sort them
        start_timing.sort()
        print(start_timing)
        end_timing.sort()
        print(end_timing)
        
        start_ptr=0
        end_ptr=0
        rooms=0
        
        while start_ptr<len(intervals):
            #it means one of the meeting has ended by the time this meeting is to start
            if start_timing[start_ptr]>=end_timing[end_ptr]:
                rooms-=1
                end_ptr+=1
            rooms+=1
            start_ptr+=1
        return rooms
            