#253. Meeting Rooms II
"""
Time Complexity : O(n logn)
Space Complexity : O(n)
"""
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        intervals.sort()
        
        #inserting in heap
        
        hq = []
        heapq.heappush(hq, intervals[0][1]) #end time
        
        print(hq)
        
        #now comparing each start time and storing end time in heap
        for i in range(1, len(intervals)):

            #if new start time is greather than old end time
            if hq[0] <= intervals[i][0]:
                #there is no need of another room. Same room can be used again.
                #poping that room becauase this means that meeting is over.
                heapq.heappop(hq)
                
            
            #if new start time is less than old end time
            #room is still occupied. 
            #So we will not remove that room because meeting has not been ended.
            heapq.heappush(hq, intervals[i][1]) 
            #pusing end time because this will be used in next iteration to check if meeting is over or not.
                
        #length of hq will be no of rooms required
        return len(hq)
