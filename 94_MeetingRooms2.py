# Leetcode(253)
'''
steps:
1. Sort the array based on start index
2. Iterate over the list items and add end times to the priority queue
3. compare the start time of next item with first element in priority queue
4. continue accordingly
'''
import heapq
def meetingRooms(intervals):
    if len(intervals) == 0:
        return 0
    sorted(intervals, key=lambda x:x[0])
    pq = []
    heapq.heappush(pq,intervals[0][1])
    for i in range(1,len(intervals)):
        peekValue = pq[0]
        # either the intervals have a difference or one after the another , this should work.
        # check for below uncommented intervals.
        if intervals[i][0] >= peekValue:
            heapq.heappop(pq)
            heapq.heappush(pq,intervals[i][1])
        else:
            heapq.heappush(pq, intervals[i][1])
    return len(pq)



# print(meetingRooms([[0,30],[5,10],[15,20]]))
# print(meetingRooms([[0,30],[5,10],[9,20],[20,30]]))
print(meetingRooms([[0,30],[5,10],[10,20],[20,30]]))

