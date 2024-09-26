"""

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.


Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Input: [[7,10],[2,4]]

Output:1

This Brute force sol Time complexity  O(N log N )+o(N^2)
Space is 0(N) for ongoing_list 

"""

class Solution:  
    def minMeetingRooms(self, intervals):
        intervals=sorted(intervals,key=lambda x:x[0])
        ongoing_list=[]
        flag=False
        for interval in intervals:
            flag= False
            for i in range(0,len(ongoing_list)):
                curr=ongoing_list[i] #tuple (start,end)
                if(interval[0]>=curr[1] ) :#interval.start >=curr.end
                    flag=True
                    ongoing_list[i]=interval
            if(not flag):
                ongoing_list.append(interval)
        return len(ongoing_list)
    

obj=Solution()
intervals=[(0, 30),(5, 10),(15, 20),(18,29),(27,28),(32,35)]
room=obj.minMeetingRooms(intervals)
print(room)
                
                    
                
                
            
            