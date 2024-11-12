# 378. Kth Smallest Element in a Sorted Matrix

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        hp = []
        for i in range(m):
            for j in range(n):
                heapq.heappush(hp,-matrix[i][j])
                if len(hp) > k:
                    heapq.heappop(hp)

        return -hp[0]
        