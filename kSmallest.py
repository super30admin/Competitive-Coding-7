#Time complexity: O(m*n)
#Space complexity: O(k)

import heapq as hq
class Comparator:
    def __init__(self, val):
        self.val = val
    def __lt__(self, other):
        return other.val < self.val
        
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                hq.heappush(heap, Comparator(matrix[i][j]))
                if len(heap) > k:
                    hq.heappop(heap)
        return heap[0].val
