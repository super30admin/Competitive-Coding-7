# Time complexity : n log k --> n - rows or cols
# Space complexity : O(n)
# Leetcode : Solved and submitted

import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        
        # insert one row or one column into the heap
        minHeap = []
        for r in range(n):
            heapq.heappush(minHeap, (matrix[r][0],r,0))
        
        # as soon as we remove the element from the heap, we insert one element from the popped row, but col + 1, we do this until k = 0
        # which gives us kth value
        while k:
            val, row, col = heapq.heappop(minHeap)
            if col < n - 1:
                heapq.heappush(minHeap, (matrix[row][col+1],row,col+1))
            k -= 1
        
        return val
