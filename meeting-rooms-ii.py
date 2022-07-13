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