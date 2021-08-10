# Time Complexity: O(k log n)
# Space Complexity: O(n) n - where n is minimum between n and k
import heapq
class Solution:
    def kthSmallest(self, matrix, k) :
        heap = []
        n = len(matrix)
        for i in range(min(n, k)):
            heapq.heappush(heap, (matrix[i][0], i, 0))

        heapq.heapify(heap)

        while k!=0:
            curr, r, c = heapq.heappop(heap)

            if c < n - 1:
                heapq.heappush(heap, (matrix[r][c + 1], r, c + 1))

            k -= 1

        return curr


