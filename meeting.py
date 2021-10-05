# // Time Complexity :O(log(m*n)), total size = row*column and binary search on it
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




from heapq import heappush as insert
from heapq import heappop as remove
class Customlist:
    def __init__(self,li):
        self.list=li
    def __lt__(self,other):
        return self.list[1]<other.list[1]
class Meeting:
    def __init__(self):
        self.r=0
    def schedule(self,li):
        li.sort() #sort based on the start time
        print(li)
        pq=[]
        start=li[0]
        print(start[1])
        for i in range(1,len(li)):
            # print(start[1])
            # print(li[i][1])
            if start[1]<=li[i][0]:
                remove(pq)

            insert(pq,(li[i][1],Customlist(li[i])))
        print(len(pq))
    
        
obj=Meeting()
obj.schedule([(0,15),(0,30),(5,10),(15,20),(21,25)])


        