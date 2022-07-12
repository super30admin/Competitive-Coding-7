""""// Time Complexity : O(Nlog(max-min))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]

        while low <= high:
            mid = low + (high - low) // 2

            elCount = self.findCount(matrix, mid)

            if elCount < k:
                low = mid + 1
            else:
                high = mid - 1
        return low

    def findCount(self, matrix, num):
        n = len(matrix)
        i = n - 1
        j = 0
        count = 0
        while i >= 0 and j < n:
            if matrix[i][j] <= num:
                count += i + 1
                j += 1
            else:
                i -= 1
        return count

""""// Time Complexity : O(Nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
#         h = []
#         count = 0
#         for i in range(len(matrix)):
#             for j in range(len(matrix[0])):
#                 heapq.heappush(h, -(matrix[i][j]))
#                 count += 1
#                 if count > k:
#                     heapq.heappop(h)
#                     count -= 1
#         return -h[0]
#





