"""
Leetcode: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Approach: Min Heap
    1. Insert the 0th column values for all the rows in a heap.
    2. Iterate k times and pop element from heap. If the popped element has
        a next valid column value, push it to heap. Decrement k.
    3. Return the response after k becomes 0 as the popped element will be kth smallest

Time Complexity: X + K log(X), where X = min(K,N)
    - heap construction takes O(X) time
    - After that, we perform K iterations and each iteration has two operations. We extract the minimum element from a heap containing X elements. Then we add a new element to this heap. Both the operations will take O(log(X)) time.
Space Complexity: O(X) which is occupied by the heap.
"""

from heapq import heappush as push
from heapq import heappop as pop


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        # The size of the matrix
        N = len(matrix)

        # Preparing our min-heap
        minHeap = []

        for row in range(min(k, N)):
            # add element, row and col for each cell
            push(minHeap, (matrix[row][0], row, 0))

        while k:
            element, row, col = pop(minHeap)

            if col < N - 1:
                push(minHeap, (matrix[row][col + 1], row, col + 1))
            k -= 1

        return element