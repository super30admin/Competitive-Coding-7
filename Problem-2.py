import heapq

intervals = [[0, 30], [5, 10], [15, 20]]

if not intervals:
    print(0)
else:
    intervals.sort(key=lambda x:x[0])

    heap = []

    heapq.heappush(heap,intervals[0][1])

    for i in range(1,len(intervals)):
        if intervals[i][0] >= heap[0]:
            heapq.heappop(heap)

    heapq.heappush(heap,intervals[i][1])

    print(len(heap))