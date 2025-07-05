# Time complexity: O(k * log n)
# Space complexity: O(n)

import heapq

def kthSmallest(matrix, k):
    """Return the kth smallest element in a sorted matrix."""
    n = len(matrix)
    minHeap = [(matrix[i][0], i, 0) for i in range(n)]
    heapq.heapify(minHeap)

    for _ in range(k):
        element, row, col = heapq.heappop(minHeap)
        if col + 1 < n:
            heapq.heappush(minHeap, (matrix[row][col + 1], row, col + 1))

    return element
