# Time Complexity : O(klogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
from collections import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        x = min(k,n)

        min_heap = []

        for i in range(x):
            heapq.heappush(min_heap, (matrix[i][0], i, 0))
        
        ct = 0
        min_el = float('inf')

        while ct != k:
            min_el, row, col = heapq.heappop(min_heap)
            ct += 1 
            col += 1
            if col != x:
                heapq.heappush(min_heap, (matrix[row][col], row, col))
        
        return min_el