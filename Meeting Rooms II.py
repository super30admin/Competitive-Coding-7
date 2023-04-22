class Solution:
    # Approach 1 Using a hashmap to store all meeting room timings and go through them to find out a available room
    # Time: O(nlogn + n**2)
    # Space: O(n)
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # intervals.sort(key=lambda x: x[0])
        # # print(intervals)
        # roomid = 1
        # rooms = defaultdict(int)
        # rooms[roomid] = intervals[0][1]
        # # rooms.append(intervals[0][1])
        # for i in range(1, len(intervals)):
        #     flag = False
        #     for rid, time in rooms.items():
        #         if time <= intervals[i][0]:
        #             rooms[rid] = intervals[i][1]
        #             flag = True
        #             break
        #     if not flag:
        #         roomid += 1
        #         rooms[roomid] = intervals[i][1]
        #     # print(rooms)
        # return len(rooms)

        # Approach 2 Using a minheap to store the meeting timings and greedily assigning times to earliest ending rooms first
        # Time : O(nlogn)
        # Space : O(n)
        # intervals.sort()
        # mheap = [] # Creating a mi heap
        # mheap.append(intervals[0][1])
        # heapq.heapify(mheap)

        # for i in range(1, len(intervals)):
        #     if intervals[i][0] >= mheap[0]:
        #         heapq.heappushpop(mheap, intervals[i][1])

        #     else:
        #         heapq.heappush(mheap, intervals[i][1])
        # return len(mheap)

        # Approach 3 Separating start and end times and then traversing both of them and checking if start time is smaller than end time
        # Time O(nlogn)
        # Space O(n)
        start = []
        end = []
        result = 0
        for i in intervals:
            start.append(i[0])
            end.append(i[1])

        start.sort()
        end.sort()

        s = 0
        e = 0
        while s < len(start):
            if start[s] < end[e]:
                s += 1
                result += 1
            else:
                s += 1
                e += 1
        return result














