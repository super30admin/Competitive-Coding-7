#TC: O(nlogn)
#SC: O(n)
class Node:
    def __init__(self,a):
        self.a=a[0]
        self.b=a[1]
from heapq import heappop as pop
from heapq import heappush as push
def min_meeting_rooms(intervals):
    if len(intervals)==0: return 0 
    intervals.sort(key = lambda x: x[0])
    hq=[]
    lessthan = lambda x, y: x.b < y.b
    Node.__lt__ = lessthan
    push(hq,Node(intervals[0]))
    for k in intervals[1:]:
        n=Node(k)
        if k[0]>hq[0].b:
            pop(hq)
        push(hq,n)
    return len(hq)


print(min_meeting_rooms([[0,30],[5,10],[15,20]]))
print(min_meeting_rooms([[0,30],[1,10],[2,20],[3,30]]))
print(min_meeting_rooms([[2,4],[7,10]]))
print(min_meeting_rooms([[0,30],[5,32],[31,50]]))

'''
#sandeeps code

def min_meeting_rooms(intervals):
  from heapq import heappush as push
  from heapq import heappop as pop
  if len(intervals)==0: return 0 
  intervals.sort()
  heap=[]
  push(heap,intervals[0][1])
  for i in range(1,len(intervals)):
    if intervals[i][0]<heap[0]:
      push(heap,intervals[i][1])
    else:
      pop(heap)
      push(heap,intervals[i][1])
  return len(heap)
print(min_meeting_rooms([[0,30],[5,10],[15,20]]))
print(min_meeting_rooms([[0,30],[1,10],[2,20],[3,30]]))
print(min_meeting_rooms([[2,4],[7,10]]))
print(min_meeting_rooms([[0,30],[5,32],[31,50]]))
'''

