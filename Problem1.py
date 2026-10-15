# https://www.thes30.com/problem/5d4e7490af22160017737e90/solutions

# Time Complexity: O(n log n), because of sorting. The while loop is O(n).
# Space Complexity: O(n), for the two extra lists (start and end times).
# # Approach:
# Split start times and end times into two separate lists and sort both.
# Walk through both lists with two pointers (i for starts, j for ends).
# If the next meeting starts before the earliest meeting ends, add a room. Otherwise, a meeting ended, so free a room.
# Track the maximum rooms used at any moment. That is the answer.


class Solution:
    def minMeetingRooms(self, intervals):
        # collect all start times
        start_time_array = [interval[0] for interval in intervals]
        # collect all end times
        end_time_array = [interval[1] for interval in intervals]

        # sort both so we can process events in time order
        start_time_array.sort()
        end_time_array.sort()

        result = 0          # maximum rooms needed at any moment
        current_rooms = 0   # rooms in use right now
        i = 0               # pointer for the next start time
        j = 0               # pointer for the next end time

        # once all meetings have started, the count can only go down
        while i < len(start_time_array):
            # next meeting starts before the earliest one ends: overlap
            if start_time_array[i] < end_time_array[j]:  # fixed: j, not i
                current_rooms += 1                       # need one more room
                result = max(result, current_rooms)      # update the peak
                i += 1                                   # move to next start
            else:
                # a meeting ended (or ends exactly when another starts)
                current_rooms -= 1                       # free one room
                j += 1                                   # move to next end

        return result  # fixed: result, not results