# Time Complexity : Add - O(n log n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
0. Sort the meetings
1. Use min heap to acces the room that has earliest end time
2. So we make a min hap based on ending time. 
3. If start time of an incoming meeting is more then peek, then we can pop and update the new meeting end time
4. Else push it to heap, thus allotting a new room
5. The length of heap gives the room required
'''


import heapq

def minMeetingRooms(intervals):#: List[List[int]]) -> int:

    if not intervals or len(intervals)<1:
        return

    intervals = sorted(intervals, key=lambda x:x[0])
    heap_list = []
    for i in range(len(intervals)):
        
        print (heap_list)

        if  i==0:
            heapq.heappush(heap_list, intervals[i][1])

        elif intervals[i][0] < heap_list[0]:
            heapq.heappush(heap_list, intervals[i][1])

        else:
            heapq.heappop(heap_list)
            heapq.heappush(heap_list, intervals[i][1])

    return len(heap_list)