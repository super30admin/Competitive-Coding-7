import heapq
from heapq import heappop, heappush
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        size = (m*n) - k + 1
        print(size)
        count = 0
        h = []
        heapq.heapify(h)
        for i in range(m):
            for j in range(n):
                if(count < size):
                    heappush(h, matrix[i][j])
                    count += 1
                elif(h[0] < matrix[i][j]):
                    heappop(h)
                    heappush(h,matrix[i][j])
                    count += 1
        print(h)
        return heappop(h)