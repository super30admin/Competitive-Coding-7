'''
Time Complexity: O(mlog k) m is rows
Space Complexity: O(m)
Did this code successfully run on Leetcode : Yes
Explanation: Push the first column of every row into a heap. Pop the smallest element and then use that row to find the
next smallest. keep doing this till u reach the kth element. The min element in the heap is the kth element.
'''

import heapq


class obj:
    def __init__(self, val, i, j):
        self.val = val
        self.i = i
        self.j = j

    def __lt__(self, other):
        return self.val < other.val


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if k == None or matrix == None:
            return 0

        heapmin = []

        for i in range(0, len(matrix)):
            temp = obj(matrix[i][0], i, 0)
            heapq.heappush(heapmin, (temp))

        while k > 1:

            mini = heapq.heappop(heapmin)

            if mini.j < len(matrix[0]) - 1:
                temp = obj(matrix[mini.i][(mini.j) + 1], mini.i, (mini.j) + 1)
                heapq.heappush(heapmin, (temp))
            k -= 1

        return heapmin[0].val
