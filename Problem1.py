# // Time Complexity : O(mnlogk) where m and n are the size of the matrix and k in the kth smallest element to find.
# // Space Complexity : O(k) where k in the kth smallest element to find.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No.

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(heap,matrix[i][j] * -1)
                if len(heap) > k:
                    heapq.heappop(heap)
        return heap[0] * -1
