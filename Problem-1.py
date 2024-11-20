class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        heap = []

        for i in range(n):
            for j in range(n):
                if len(heap) < k:
                    heapq.heappush(heap,-matrix[i][j])
                else:
                    if -heap[0] > matrix[i][j]:
                        heapq.heappushpop(heap,-matrix[i][j])

        return -heap[0]
        