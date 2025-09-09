class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n=len(matrix)
        min_heap=[]

        for i in range(n):
            heapq.heappush(min_heap, (matrix[i][0], i, 0))
        
        val=-1
        for _ in range(k):
            val, r, c=heapq.heappop(min_heap)
            if c+1<n:
                heapq.heappush(min_heap, (matrix[r][c+1], r, c+1))
        
        return val


        




