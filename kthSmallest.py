# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

# Maxheap solution
# TC: O(n^2)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        res = 0
        maxheap = []

        if not matrix:
            return -1

        for i in range(len(matrix)):
            row = matrix[i]
            
            for num in row:
                heapq.heappush(maxheap, -num)
                if len(maxheap) > k:
                    heapq.heappop(maxheap)
                    
        return -maxheap[0]

# Minheap solution
# TC: O(k log n)
# SC: O(n)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        minheap = []
        n = len(matrix)

        for r in range(n):
            heapq.heappush(minheap, (matrix[r][0], r, 0))

        for _ in range(k):
            val,r,c = heapq.heappop(minheap)

            if c + 1 < len(matrix[0]):
                heapq.heappush(minheap, (matrix[r][c+1], r, c+1))

        return val

        