class Solution:
    # TC : O(mn* log k)
    # SC : O(k)
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if matrix is None:
            return 0
        m,n = len(matrix),len(matrix[0])
        heap = []
        ct = m*n
        for i in range(m):
            for j in range(n):
                if len(heap) < k:
                    heapq.heappush(heap,-matrix[i][j])
                else:
                    heapq.heappushpop(heap,-matrix[i][j])
        return -1*heap[0]
        