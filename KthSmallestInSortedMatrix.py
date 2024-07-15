# Time Complexity : O(klongn)
# Space Complexity : O(n)

import heapq

class Solution:
    def kthSmallest(self, matrix, k):
        n = len(matrix)
        min_heap = []

        # Initialize the heap with the first element of each row
        for row in range(n):
            heapq.heappush(min_heap, (matrix[row][0], row, 0))

        # Extract-min k times
        small = 0
        for _ in range(k):
            small, row, col = heapq.heappop(min_heap)

            # If there are more elements in the row, add the next element to the heap
            if col + 1 < n:
                heapq.heappush(min_heap, (matrix[row][col + 1], row, col + 1))

        return small

# Examples
solution = Solution()

matrix1 = [
    [1, 5, 9],
    [10, 11, 13],
    [12, 13, 15]
]
k1 = 8
print(solution.kthSmallest(matrix1, k1)) # Expected output: 13

matrix2 = [
    [1, 2],
    [1, 3]
]
k2 = 3
print(solution.kthSmallest(matrix2, k2)) # Expected output: 2

matrix3 = [
    [-5, -4],
    [-3, -1]
]
k3 = 2
print(solution.kthSmallest(matrix3, k3)) # Expected output: -4