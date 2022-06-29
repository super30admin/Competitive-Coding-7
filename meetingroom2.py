'''
time complexity: O(nlogn)
space complexity: O(n)
n is space occupied by heap
'''
import heapq

class wrapper:
    def __init__(self,arr):
        self.arr = arr
    def __lt__(self,other):
        return self.arr[1] < other.arr[1]
    def __str__(self):
        print("{} , {}".format(self.arr[0] , self.arr[1]))
        return "{} , {}".format(self.arr[0] , self.arr[1])
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda arr: arr[0])
        
        hls = []
        #[[0,30],[5,10],[15,20]]
        
        for i in range(len(intervals)):
            
            if(len(hls)!=0 and hls[0].arr[1]<=intervals[i][0]):
                #[0 30]
                print("in if")
                heapq.heappop(hls)
            #[0,30] [15 20]
            heapq.heappush(hls,wrapper(intervals[i]))
            print(hls[0].arr[1])
        return len(hls)