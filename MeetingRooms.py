'''
Solution:
1.  First sort all intervals based on starting times of those intervals.
2.  Then check the min end time of elements using minHeap if next element in sorted array
    has end time less than min end time => overlapping => add to minHeap, else remove 
    min end time element as no other interval clashes

Time Complexity:    O(NlogN + NlogN) -- sorting + minHeap ~ O(NlogN)
Space Complexity:   O(N) [Heap contains N elements in the worst case]

--- Passed few custom test cases 
'''


from heapq import heappush as insert
from heapq import heappop as remove

class Interval:

    #   stores start and end time of a meeting
    def __init__(self, start, end):
        self.start = start
        self.end = end

        #   custom =, <, <=, >, >=, != operators defined for the class
    def __eq__(self, other):
        return self.end == other.end

    def __ne__(self, other):
        return self.end != other.end

    def __lt__(self, other):
        return self.end < other.end

    def __le__(self, other):
        return self.end <= other.end

    def __gt__(self, other):
        return self.end > other.end

    def __ge__(self, other):
        return self.end >= other.end

    def __repr__(self):
        return '%d %d' % (self.start, self.end)


class MeetingRoomScheduler:

    def findMinNoOfMeetingRooms(self, intervals: list) -> int:

        #   edge case check
        if (intervals == None or len(intervals) == 0):
            return 0

        #   sort the array based on start times
        intervals.sort(key= lambda x: x.start)

        #   initialize minHeap with one element
        minHeap = [intervals[0]]

        #   first check the min end time of elements using minHeap
        #   if next element in sorted array has end time less than min end time => overlapping => add to minHeap
        #   else remove min end time element as no other interval clashes
        for i in range(1, len(intervals)):
            minEnd = minHeap[0].end
            if (intervals[i].start >= minEnd):
                remove(minHeap)
            insert(minHeap, intervals[i])

        #   return the count left in minHeap as those many rooms will be required.
        return len(minHeap)

def main():
    #   testcases
    mrs = MeetingRoomScheduler()

    intervals = [Interval(0, 30), Interval(5, 10), Interval(15, 20)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 2

    intervals = [Interval(2, 5), Interval(0, 31), Interval(32, 37), Interval(7, 35)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 2

    intervals = [Interval(2, 5), Interval(0, 2), Interval(5, 37), Interval(37, 38)]
    print(mrs.findMinNoOfMeetingRooms(intervals))                       #   answer: 1

if __name__ == '__main__':
    main()