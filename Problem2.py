#TimeComplexity:- O(nlog)
#space Complexity:- O(n)

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        startArray = []
        endArray = []

        for i in range(len(intervals)):
            startArray.append(intervals[i][0])
            endArray.append(intervals[i][1])
        startArray.sort()
        endArray.sort()
        startPointer = 0
        endPointer = 0
        meetingRoomsOccupied = 0
        if len(intervals) == 1:
            return 1
        if len(intervals) == 0:
            return 0
        while startPointer < len(intervals) :
            if startArray[startPointer] >= endArray[endPointer]:
                meetingRoomsOccupied -= 1
                endPointer += 1
            meetingRoomsOccupied+=1
            startPointer+=1
        return meetingRoomsOccupied




#ANother Approach using Priority Queues:
#Time Complexity :- O(nlogn)
#Space Complexity :- O(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        freeRooms = []
        
        intervals.sort(key=lambda x:x[0])
        print(intervals)
        heapq.heappush(freeRooms, intervals[0][1])
        for i in intervals[1:]:
            if freeRooms[0] <= i[0]:
                heapq.heappop(freeRooms)
            heapq.heappush(freeRooms, i[1])
        return len(freeRooms)

