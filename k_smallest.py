class Solution:
    def kthSmallest(self, matrix, k):
        m = len(matrix)
        n = len(matrix[0])

        low = matrix[0][0]
        high = matrix[m - 1][n - 1]

        while low <= high:
            mid = low + (high - low) // 2
            count = self.getCount(matrix, m, n, mid)
            if count < k:
                low = mid + 1
            else:
                high = mid - 1

        return low

    def getCount(self, matrix, m, n, target):
        count = 0
        for i in range(m):
            count += self.binarySearch(matrix[i], target)
        return count

    def binarySearch(self, row, target):
        low, high = 0, len(row) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if row[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low

# Time: O(m * log n * log(max - min))
# Space: O(1)