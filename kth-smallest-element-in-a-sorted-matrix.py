# tc O(n + k log n), sc O(n).
minheap = []
import heapq
ROWS = COLUMNS = len(matrix)
for row in range(ROWS):
    minheap.append((matrix[row][0], row, 0))
heapq.heapify(minheap)

while minheap:
    num, row, column = heapq.heappop(minheap)
    if k == 1:
        return num
    k -= 1

    if column + 1 < COLUMNS:
        heapq.heappush(minheap, (matrix[row][column+1], row, column+1))
