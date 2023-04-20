# TC : O(min(k, N) + Klog(min(k, N)))
# SC : O(min(k, N))

import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        minHeap = []
        for r in range(min(k, n)):
            minHeap.append((matrix[r][0], r, 0))

        heapq.heapify(minHeap)

        while k:
            elem, r, c = heapq.heappop(minHeap)
            if c < n - 1:
                heapq.heappush(minHeap, (matrix[r][c+1], r, c+1))
            k -= 1
        return elem


