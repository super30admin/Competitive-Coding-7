#Time Complexity - O(m*n)
#Space Complexity - O(k)
import heapq
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        q = []
        for i in range(len(matrix)):
            for j in range(len(matrix)):
                heapq.heappush(q,matrix[i][j]*-1)
                if len(q) > k:
                    heapq.heappop(q)
        return heapq.heappop(q)*-1