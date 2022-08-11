# Time Complexity: nlog(n)
# Space Complexity: log(n)

def minMeetingRooms(intervals):
    intervals.sort()

    start = []
    for i in range(len(intervals)):
        start.append(intervals[i][0])

    end = []
    for i in range(len(intervals)):
        end.append(intervals[i][1])

    res = 0
    count = 0
    start_pointer = 0
    end_pointer = 0
    for i in range(len(intervals)):
        if start[start_pointer] < end[end_pointer]:
            start_pointer += 1
            count += 1
        else:
            end_pointer += 1
            count -= 1
        res = max(res, count)

    return res
