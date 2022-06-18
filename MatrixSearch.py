#Time Complexity: O(mnlogk)
#Space Complexity: O(k)
import heapq as hq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        m, n = len(matrix), len(matrix[0])  # For general, matrix doesn't need to be a square
        heap = []
        for r in range(m):
            for c in range(n):
                hq.heappush(heap, -matrix[r][c])
                if len(heap) > k:
                    hq.heappop(heap)

        return -hq.heappop(heap)
