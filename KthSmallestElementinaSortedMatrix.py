# Time Complexity : O(NlogK)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Max Heap - Since we cannot build max heap in python we make the value negative to make the maximum element to bubble up at the top.
# We iterate through all the N elements in the list so that takes O(N) and we build the max heap of size K and add K elements to the heap.
# If the size of heap is greater than k pop the top element from heap
# Return the top element from the heap making the value positive

import heapq


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return None
        heap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(heap, -(matrix[i][j]))
                if len(heap) > k:
                    heapq.heappop(heap)
        return -heapq.heappop(heap)