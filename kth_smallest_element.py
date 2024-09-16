# Time Complexity : O(n*log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        m = len(matrix)
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low <= high:
            count = 0
            mid = low + (high-low)//2
            sx = m-1
            sy = 0
            while 0 <= sx and sy < m:
                if matrix[sx][sy] <= mid:
                    count += (sx+1)
                    sy += 1
                elif matrix[sx][sy] > mid:
                    sx -= 1
            if count < k:
                low = mid + 1
            else:
                high = mid - 1
        return low


print(Solution().kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 8))


# class Solution:
#     def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
#         heap = []
#         mini = -sys.maxsize
#         m = len(matrix)
#         n = len(matrix[0])
#         for i in range(m):
#             for j in range(n):
#                 heapq.heappush(heap, matrix[i][j])
#                 if len(heap) > (m*n) - k:
#                     mini = max(mini, heapq.heappop(heap))
#         return mini
#
#
# print(Solution().kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 8))
