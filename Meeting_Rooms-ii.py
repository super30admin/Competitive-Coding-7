// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
First we have to sort the timings based on start time and then traverse through the list to add the end timings to the minheap.FOr every timing we see if the start time is less than the minimum end time in the heap.If Yes we need a new conference room else we pop it from the heap.The count gives us the minimum number of conference rooms required for the given timings.

# Time complexity --> o(nlogn)
# space complexity --> o(logn)
timings=[[7,10],[2,4]]
import heapq
from operator import itemgetter
h=[]
count=1
timings=sorted(timings,key=itemgetter(1))
print(timings)
heapq.heappush(h,timings[0][1])
for i in range(1,len(timings)):
    val=timings[i]
    start=val[0]
    end=val[1]
    if start<h[0]:
        count=count+1
    else:
        heapq.heappop(h)
    heapq.heappush(h,end)
print(count)