# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

# Time complexity: O(X) where x is min of n and k 
# Space complexity: O(X)
# Explanation: Store all the first column values with r and c in min heap, then keep popping and iterating k times
# At the end you should get the kth smallest value

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        minheap = []
        for r in range(min(k, n)):
            minheap.append((matrix[r][0], r, 0))
        heapq.heapify(minheap)
        while k:
            element, r, c = heapq.heappop(minheap)
            if c < n - 1:
                heapq.heappush(minheap, (matrix[r][c+1], r, c+1))
            k -= 1
        return element
