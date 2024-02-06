'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
Firstly sort the (start_time,end_time) tuple pairs based on start time and add them to a heap. The class about to end the earliest is on top
of the heap always. While I loop thru the list of classes sorted according to start time, I try to fit classes that can run with minimum number
of rooms. At any point, the length of heap equals the number of classes running parallely

'''

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        conference = []

        for i,j in intervals:
            conference.append((i,j))

        sorted_list = sorted(conference, key=lambda x: x[0])

        print(conference)
        end_time = []
        rooms = 0

        for (a,b) in sorted_list:
            if not end_time:
                heapq.heappush(end_time,b)
                rooms = max(rooms,len(end_time))

            else:
                time = heapq.heappop(end_time)
                if time <= a:
                    heapq.heappush(end_time,b)
                else:
                    heapq.heappush(end_time,b)
                    heapq.heappush(end_time,time)

                rooms = max(rooms,len(end_time))

        return rooms




