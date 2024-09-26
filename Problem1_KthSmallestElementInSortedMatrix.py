# Time Complexity: O(N logn), where N - size of matrix and n = max element - min element
# Space Complexity: O(1)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)

        # Consider the first element as low and last element as high
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]

        # Binary search the number whose count is k
        while low < high:
            mid = low + (high - low) // 2
            count = self.get_count(matrix, mid)
            if count < k:
                low = mid + 1
            else:
                high = mid

        return low

    # Returns the number of elements before mid
    def get_count(self, matrix: List[List[int]], mid: int) -> int:
        count = 0
        n = len(matrix)
        j = n - 1
        for i in range(n):
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count += j + 1

        return count






