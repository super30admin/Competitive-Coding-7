# Time Complexity : O(X + Klog(X))
# Space Complexity : O(X)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq
from typing import List


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        h = []

        # going through elements int he matrix and appending them to the heap
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                h.append(matrix[i][j])

        heapq.heapify(h)

        # iterating through k range of elements
        for i in range(k - 1):
            heapq.heappop(h)  # popping top elements

        return h[0]  # returning the top element
