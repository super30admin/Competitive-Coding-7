# Created by Aashish Adhikari at 12:08 AM 3/24/2021

'''
Time Complexity:
O(nlogn)

Space Complexity:
O(n)
'''

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """


        # Sort the time intervals according to the start time and for each task, check if a previous task completes so that a room is freed,
        # if not, add the count of the rooms required



        start_times = [task[0] for task in intervals] # O(n)
        end_times = [task[1] for task in intervals] # O(n)

        # sort the start and end times
        start_times.sort() # O(nlogn)
        end_times.sort() # O(nlogn)

        # for a task, if there is a room available when it starts, then no new room needs to be assigned, else generate a new room

        total_rooms = 0
        available_rooms = 0
        start_idx = 0
        end_idx = 0

        # Need to go only upto when start_idx ends because no more rooms will be needed when the last task is started
        while start_idx < len(intervals): # O(2n)

            if end_times[end_idx] < start_times[start_idx]:

                # a room is freed, move the end index to the next value. The task at current start_idx has not started yet though.
                available_rooms += 1
                end_idx += 1

            elif end_times[end_idx] == start_times[start_idx]:
                # The task that ends at end_idx completes as well as the task at start_idx starts.
                # So, one room free but one room taken, so no change in available rooms
                start_idx += 1
                end_idx += 1
            else:
                # need a room, if available, use that room, else increase the number of rooms required. The current task at start_idx is started.
                if available_rooms == 0:
                    total_rooms += 1
                else:
                    available_rooms -= 1


                start_idx += 1

        return total_rooms


