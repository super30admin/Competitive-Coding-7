# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import heapq


class Solution:
    def kthSmallest(self, matrix,k):
        rows, cols = len(matrix), len(matrix[0])
        pq = []
        for r in range(rows):
            for c in range(cols):
                curr = matrix[r][c]
                heapq.heappush(pq, (-curr, r, c))
                if len(pq) > k:
                    heapq.heappop(pq)
        top = pq[0]
        return -top[0]
