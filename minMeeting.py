# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


import heapq

class Solution():
    def findMinRooms(self,arr):
        if len(arr)==0 or arr is None:
            return 0
        #sort the array
        arr.sort()
        c = 1
        print('arr ',arr)
        #create a pq to store endtime
        endtime = []
        heapq.heappush(endtime,arr[0][1])
        print('----endtime ',endtime)
        for i in range(1,len(arr)):
            #check if start time is lesser than existing endtime in the queue ->overlap = YES
            if arr[i][0]<endtime[0]:
                print('arr[i][0]-',arr[i][0])
                print('endtime[0]-',endtime[0])
                c+=1
                print('if c-----',c)
            else:
                #No overlap. Remove time from the endtime
                print('else c---',c)
                heapq.heappop(endtime)
                print('endtime--',endtime)
            heapq.heappush(endtime,arr[i][1])
            print('endtime added-',endtime)
                

        return c

