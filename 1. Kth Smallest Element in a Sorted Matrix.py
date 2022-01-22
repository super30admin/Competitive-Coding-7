import heapq
class Solution:
    def kthSmallest(self, matrix, k: int):
        # Time Complexity - O(X + klog(X)) where X = min(k,N)
        # Space Complexity - O(X)
        h = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                h.append(matrix[i][j])
        heapq.heapify(h)
        for i in range(k - 1):
            heapq.heappop(h)
        return h[0]
