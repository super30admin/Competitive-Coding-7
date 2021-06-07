import heapq
from typing import  List
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if len(matrix) == 0 or len(matrix[0])==0: return -1
        heap= []
        for row in range(len(matrix)):
            for column in range(len(matrix[0])):
                heapq.heappush(heap,-1* matrix[row][column])
                if heap.__len__() > k:
                    heapq.heappop(heap)
        return -1 * heapq.heappop(heap)
