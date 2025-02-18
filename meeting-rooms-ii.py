# tc O(n log n), sc O(n).
intervals.sort()
occupied_rooms_endtimes = [intervals[0][1]]
heapq.heapify(occupied_rooms_endtimes)

for idx in range(1, len(intervals)):
    if intervals[idx][0] >= occupied_rooms_endtimes[0]:
        heapq.heappop(occupied_rooms_endtimes)
    heapq.heappush(occupied_rooms_endtimes, intervals[idx][1])

return len(occupied_rooms_endtimes)