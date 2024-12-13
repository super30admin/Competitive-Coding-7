# The kthSmallest method finds the kth smallest element in a sorted matrix.

# Use a max-heap to store the k smallest elements as negative values.
# Iterate through the matrix:
# - Add elements to the heap until its size reaches k.
# - If the current element is smaller than the largest in the heap, replace the largest using heappushpop.

# Return the negated root of the heap to get the kth smallest element.

# TC: O(n^2 log k) - Traversing the matrix and maintaining a heap of size k.
# SC: O(k) - Space for the heap.


import heapq
from typing import List


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        h = []
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                val = -matrix[i][j]
                # Checking if the length of the heap is less than k
                if len(h) < k:
                    # Add the value to the heap
                    heapq.heappush(h, val)
                # Checking if the value is greater than the root element in the heap
                elif val > h[0]:
                    # push the new val to the heap while popping the root element
                    heapq.heappushpop(h, val)
        # Returning the absolute value of the root to get the kth smallest element
        return -h[0]


        