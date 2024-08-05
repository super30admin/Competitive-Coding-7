###253. Meeting Rooms II################################################################################################
// Time Complexity : nlogn + nlogk
// Space Complexity : k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We first sorted the meeting on basis of start time and than inserted the meeting end time in heap, when next meeting is encountered and check if start time is > the end time of previous meeting if it is treated than it than we inserted the new meeting end time and popped out the top element in case the start time of meeting is <= previous meeting end time we add it to heap.
At last the size of head will help us to determine the number of meeting rooms.


import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        #print(res)
        minHeap=[intervals[0][1]]
        heapify(minHeap)
        print(minHeap)
        for i in range(1,len(intervals)):
            s,e=intervals[i]
            if s<minHeap[0]:
                print('in if')
                heappush(minHeap,e)
            else:
                print('in else')
                heappop(minHeap)
                heappush(minHeap,e)
        return len(minHeap)
            
        