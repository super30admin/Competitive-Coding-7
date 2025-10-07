import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m=len(matrix)
        n=len(matrix[0])
        pq=[]

        for i in range(m):
            for j in range(n):
                heapq.heappush(pq,-matrix[i][j])
                if len(pq)>k:
                    heapq.heappop(pq)
        
        return -pq[0]
        