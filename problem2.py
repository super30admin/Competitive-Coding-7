#meeting rooms 2
# // Time Complexity :  O(n log n) 
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

import heapq

def min_meeting_rooms(intervals) -> int:
    intervals.sort( key=lambda x:x.start)       #sort the intervals by start time
    nums=[]
    heapq.heappush(nums, intervals[0].end)      #add the end time to a minheap
    for i in intervals[1:]:
        if nums[0] <= i.start:                  #for the end times, if they are less than start time, then pop them, else add another end time to min heap
            heapq.heappop(nums)
        heapq.heappush(nums, i.end)
    return len(nums)                    #return the length of the array with the remaining end times.