# Problem - Meeting rooms

# time complexity - O(n) --O(n) to create heap and O(n) to allot conference rooms 
# space complexity - O(n) -- n is the length of intervals O(2n) for heap and dictionary

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        meeting_time = []
        for interval in intervals:                # O(n)
            heapq.heappush(meeting_time, interval)
        
        conference_rooms = dict()
        while meeting_time:
            roomfound = False
            curr_meeting = heapq.heappop(meeting_time)
            for room in conference_rooms:
                if conference_rooms[room] <= curr_meeting[0]:
                    conference_rooms[room] = curr_meeting[1]
                    roomfound = True
                    break
            
            if not roomfound:
                # create another room
                rooms = conference_rooms.keys()
                new_room = max(rooms)+1 if len(rooms)!=0 else 1
                conference_rooms[new_room] = curr_meeting[1]
        
        rooms = conference_rooms.keys()
        return max(rooms) if len(rooms)!=0 else 0


# time complexity - O(nlogn)
# space complexity - O(n)

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key = lambda x: x[0]) # O(nlogn)
        heaprooms = []
        for interval in intervals:                          # O(nlogn) -- n elements, log n to heapify
            if heaprooms and heaprooms[0] <= interval[0]:    
                heapq.heappop(heaprooms)        
            heapq.heappush(heaprooms, interval[1])
        
        return len(heaprooms)