# Time Complexity : O(nlogn) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Interval:

    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        return self.end < other.end
    
    def __repr__(self):
        return '%d %d' % (self.start, self.end)
import heapq
class Solution:
    def findMinNoOfMeetingRooms(self, intervals):
        if intervals == None or len(intervals) == 0:
            return 0 
        
        intervals.sort()                                # NlogN
        booked = []
        heapq.heappush(booked, intervals[0].end)
        count = 1 
        
        for i in range(1,len(intervals)):               # O(N)
            start = intervals[i].start
            curr = heapq.heappop(booked)        
            if start >= curr:
                # i am able to book 
                heapq.heappush(booked, intervals[i].end)        #KlogK, but k will happen n times, NlogN
            else:
                count += 1 
                heapq.heappush(booked, curr)
                heapq.heappush(booked, intervals[i].end)
        
        return count 
            
        
def main():
    #   testcases
    mrs = Solution()

    # Test case 1
    intervals = [Interval(0, 30), Interval(5, 10), Interval(15, 20)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 2

    # Test case 2
    intervals = [Interval(2, 5), Interval(0, 31), Interval(32, 37), Interval(7, 35)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 2

    # Test case 3
    intervals = [Interval(2, 5), Interval(0, 2), Interval(5, 37), Interval(37, 38)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 1

if __name__ == '__main__':
    main()