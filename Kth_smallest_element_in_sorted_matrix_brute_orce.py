import heapq 
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        row = len(matrix)
        col = len(matrix[0])
        min_heap = []
        for i in range(row):
            for j in range(col):
                heapq.heappush( min_heap, matrix[i][j]  )
        # print(min_heap)
        while k > 1 :
            heapq.heappop(min_heap)
            k -= 1
        return heapq.heappop(min_heap)
