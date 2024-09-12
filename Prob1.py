from Queue import PriorityQueue
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if intervals is None or len(intervals) == 0:
            return 0
        intervals.sort(key=lambda x:x[0])
        print(intervals)
        minHeap = PriorityQueue()
        minHeap.put(intervals[0][1])
        confRooms = 1
        for idx in xrange(1,len(intervals)):
            newStartTime = intervals[idx][0]
            newEndTime = intervals[idx][1]
            minEndTime = minHeap.get()
            minHeap.put(minEndTime)
            if newStartTime >= minEndTime:
                minHeap.get()
                minHeap.put(newEndTime)
            else:
                confRooms += 1
                minHeap.put(newEndTime)
        return confRooms
                
            
        
