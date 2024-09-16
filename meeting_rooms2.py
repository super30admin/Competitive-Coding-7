from Queue import PriorityQueue
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if not intervals:
            return 0

        # The heap initialization
        heapq=PriorityQueue()

        # Sort the meetings in increasing order of their start time.
        intervals.sort(key= lambda x: x[0])

        # Add the first meeting. We have to give a new room to the first meeting.
        heapq.put(intervals[0][1])
  
        # For all the remaining meeting rooms
        for i in intervals[1:]:

            # If the room due to free up the earliest is free, assign that room to this meeting.
            if heapq.queue[0] <= i[0]:
                heapq.get()

            # If a new room is to be assigned, then also we add to the heap,
            # If an old room is allocated, then also we have to add to the heap with updated end time.
            heapq.put(i[1])

        # The size of the heap tells us the minimum rooms required for all the meetings.
        return (heapq).qsize()