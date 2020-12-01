# Time Complexity:  O(min(K, N) + K*logN) - N is number of rows
# Space Complexity: O(N)
# Approach: Push the first element of every list in a minheap. Pop out the smallest and append the next element from the same list. Repeat this K times, the last element popped out is the Kth smallest.
from heapq import *


class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        minheap = []

        # Insert the first element of every list in the minheap
        for li_index, li in enumerate(matrix):
            # Push the index and a reference to the list
            heappush(minheap, (li[0], 0, li_index))

        count = 0
        res = 0
        while minheap:
            el, index, li = heappop(minheap)
            res = el
            count += 1
            # If count is K, break
            if count == k:
                break
            if index + 1 < len(matrix[li]):
                heappush(minheap, (matrix[li][index+1], index+1, li))

        return res
