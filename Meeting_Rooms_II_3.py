# Created by Aashish Adhikari at 11:36 AM 3/24/2021

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

        import heapq

        # create a priority queue for the end times
        minheap_for_end_times = []

        for idx in range(len(intervals)): # O(n)

            heapq.heappush(minheap_for_end_times, intervals[idx][1]) # O(logn)

        # sort the tasks according to the starting times
        intervals.sort(key = lambda tuplee : tuplee[0]) # sorts the list in-place according to the first element of the tuple # O(nlogn)

        # Iterate thru the sorted tasks and see if new rooms need to be assigned
        total_rooms = 0
        available_rooms = 0
        task = 0

        while task < len(intervals): #O(n)

            if intervals[task][0] < minheap_for_end_times[0]:
                if available_rooms == 0:
                    total_rooms += 1
                else:
                    available_rooms -= 1

                task += 1
            else:
                available_rooms += 1
                heapq.heappop(minheap_for_end_times)

        return total_rooms






