# 378. Kth Smallest Element in a Sorted Matrix
# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

# Logic: Make a max heap while iterating the input. 
# When the size of the heap becomes more than k, 
# pop the max element.

# Time Complexity: O(n + klogk)
# Space Complesxity: O(k)

import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        
        n = len(matrix)
        m = len(matrix[0])
        
        for i in range(n):
            for j in range(m):
                heapq.heappush(heap,-matrix[i][j])
                
                if len(heap) > k:
                    heapq.heappop(heap)
        return -heap[0]