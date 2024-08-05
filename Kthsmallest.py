import heapq
def kthSmallest(matrix, k):
    min_heap = []

    for row in matrix:
        for num in row:
            heapq.heappush(min_heap,-num)

            if len(min_heap)>k:
                heapq.heappop(min_heap)
    return -heapq.heappop(min_heap)


matrix = [[1,5,9],[10,11,13],[12,13,15]]
k = 8

print(kthSmallest(matrix, k))

# time = O(n * m * log(n))
# space = O(k)