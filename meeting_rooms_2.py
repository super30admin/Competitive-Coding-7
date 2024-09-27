##Two level sort!!!!
#O(nlogn) solution with heap
#O(n) space
'''
Sort by start time, everytime all the rooms are taken, we add a room to the count. When
at one element, we check if there are any rooms available (end time< present_start_time).
If there is, we change the end time for this room. if not , we add a room and give it
the present end time. We use heap to get availability faster (just get the min).
'''
class Solution:
    def minMeetingRooms(self, people: List[List[int]]) -> List[List[int]]:
        #edge case
        if not people:
            return 0
        people.sort(key=operator.itemgetter(0,1)) #2 level sort 
        heap=[]
        rooms=0
        for person in people:
            if not rooms:
                heapq.heappush(heap, person[1])
                rooms+=1
            else:
                if heap[0]<=person[0]:
                    heapq.heappop(heap)
                    heapq.heappush(heap, person[1])
                else:
                    rooms+=1
                    heapq.heappush(heap, person[1])
        return rooms
