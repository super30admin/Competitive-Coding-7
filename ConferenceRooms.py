class Solution:
    def meetingRooms(self, intervals):
        
        #Here we sort the intervals according to their start times. Then we add end times of each interval to minHeap. Each interval we check if min element(root) of heap is smaller than or equal to current start time, if yes same room can be used hence we pop it out from heap.
        #Time complexity - O(nlogn) where n is no. of intervals
        #Space complexity - O(n) - heap size
        
        minHeap = []
        
        intervals.sort(key=lambda x:x[0])
        
        for s, e in intervals:
            if minHeap and s>=minHeap[0]:
                heapq.heappop(minHeap)
            heapq.heappush(minHeap, e)
                
        return len(minHeap)
                    
                
s = Solution()
res = s.meetingRooms([[0,25],[10,25],[10,15],[15,25],[20,25]])
print(res)