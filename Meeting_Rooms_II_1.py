# Created by Aashish Adhikari at 5:23 PM 3/20/2021

'''

Time Limit exceeds for this solution.

Time Complexity:
O(t . (e-s)) where t = no of total tasks, s = earliest time step among all tasks, e = last time step among all tasks

Space Complexity:
O(t) for the hashmap.
'''

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """

        # creates an array that contains the total number of overlapping tasks at any point in time


        no_of_tasks_existing_simultaneously = {}

        for task in range(len(intervals)): # O(t)

            start = intervals[task][0]
            end = intervals[task][1]

            for point_in_time in range(start+1, end+1): # O(e-s) where e is the last time step among all the tasks and s is the first time step among all the tasks

                if point_in_time in no_of_tasks_existing_simultaneously:
                    no_of_tasks_existing_simultaneously[point_in_time] += 1
                else:
                    no_of_tasks_existing_simultaneously[point_in_time] = 1


        return max(no_of_tasks_existing_simultaneously.values()) # # O(e-s) since there are e-s number of distinct time steps.


