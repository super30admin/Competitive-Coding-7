class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        

        m=len(matrix)
        n=len(matrix[0])
        heap=[]
        for i in range(m):
            for j in range(n):
                heapq.heappush(heap,-matrix[i][j])

                if len(heap)>k:
                    heapq.heappop(heap)

        return -heap[0]
