#Time Complexity : O(n log n)
#Space Complexity :O(1)

def canAttendMeetings(intervals):
    intervals.sort(key=lambda x: x[0])  # Sort intervals based on start time

    for i in range(1, len(intervals)):
        if intervals[i][0] < intervals[i-1][1]:  # Check for overlap
            return False
    return True