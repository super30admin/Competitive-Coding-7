class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0
        
        heap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heappush(heap,-matrix[i][j])
                if len(heap) > k:
                    heappop(heap)
        
        return heappop(heap) * -1
