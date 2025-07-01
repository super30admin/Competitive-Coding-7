# ----------------------------------------------------
# Intuition:
# We are given an n x n matrix with each row and column sorted in non-decreasing order.
# The task is to return the k-th smallest element.

# A brute-force solution would flatten the matrix, sort it, and return the k-th element.
# A better solution uses a max heap of size k to track the k smallest elements seen so far.
# The optimal solution uses Binary Search over the value range (not index),
# leveraging the matrix's sorted properties to count how many elements are <= mid.


# ----------------------------------------------------
# Time Complexity: O(n * log(max - min))
# - Binary search on the range of values → log(max - min)
# - For each mid, we count elements ≤ mid in O(n) time
#
# Space Complexity: O(1)
# - No extra space is used apart from variables
# ----------------------------------------------------

from typing import List

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)

        def countLessEqual(mid):
            count = 0
            row = n - 1
            col = 0
            while row >= 0 and col < n:
                if matrix[row][col] <= mid:
                    count += row + 1
                    col += 1
                else:
                    row -= 1
            return count

        left, right = matrix[0][0], matrix[-1][-1]
        while left < right:
            mid = (left + right) // 2
            if countLessEqual(mid) < k:
                left = mid + 1
            else:
                right = mid
        return left

# ------------------------------------------------------
# Min Heap Approach (Commented)
#
# Time Complexity: O(k log n)
# - Initial heap contains up to n elements (first column)
# - We do k pops, each taking O(log n)
#
# Space Complexity: O(n)
# - Heap stores up to n elements
#
# Intuition:
# - Use a min heap storing (value, row, col)
# - Pop smallest, push the next element in the same row
#
#         import heapq
#         heap = []
#         n = len(matrix)
#
#         for i in range(min(k, n)):
#             heapq.heappush(heap, (matrix[i][0], i, 0))
#
#         while k > 0:
#             val, r, c = heapq.heappop(heap)
#             k -= 1
#             if c + 1 < n:
#                 heapq.heappush(heap, (matrix[r][c + 1], r, c + 1))
#
#         return val

# ------------------------------------------------------
# Brute Force Approach (Commented)
#
# Time Complexity: O(n^2 log n)
# - Flattening the matrix takes O(n^2)
# - Sorting takes O(n^2 log n)
#
# Space Complexity: O(n^2)
# - Stores all elements in a separate array
#
# Intuition:
# - Collect all elements, sort, and return the k-th one
#
#         res = []
#         rows = len(matrix)
#         cols = len(matrix[0])
#
#         for i in range(rows):
#             for j in range(cols):
#                 res.append(matrix[i][j])
#
#         res.sort()
#         return res[k - 1]

# ----------------------------
# Test Cases
# ----------------------------
if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
    matrix1 = [[1, 5, 9], [10, 11, 13], [12, 13, 15]]
    k1 = 8
    print(sol.kthSmallest(matrix1, k1))  # Expected: 13

    # Test Case 2
    matrix2 = [[-5]]
    k2 = 1
    print(sol.kthSmallest(matrix2, k2))  # Expected: -5

    # Test Case 3
    matrix3 = [[1, 2], [1, 3]]
    k3 = 2
    print(sol.kthSmallest(matrix3, k3))  # Expected: 1

    # Test Case 4
    matrix4 = [[1, 3, 5], [6, 7, 12], [11, 14, 14]]
    k4 = 6
    print(sol.kthSmallest(matrix4, k4))  # Expected: 11
