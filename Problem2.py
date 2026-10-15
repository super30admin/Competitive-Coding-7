#https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
# Time Complexity: O(m * log n * log(max - min)),Outer binary search over the value range runs log(max - min) times (about 31 steps). Each step counts elements <= mid using one binary search per row: m * log n.
# Space Complexity: O(1), only a few variables are used.
# Approach:
# Binary search on the VALUE, not on the index. Range is smallest to largest element.
# For each mid, count how many elements are <= mid (binary search in each sorted row).
# If count < k, the answer is bigger than mid, so go right. Otherwise the answer is mid or smaller, so go left.
# When the loop ends, low is the smallest value whose count is >= k. That value is always a real matrix element, so it is the kth smallest.

class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        m = len(matrix)       # number of rows
        n = len(matrix[0])    # number of columns

        low = matrix[0][0]            # smallest value is the top-left corner
        high = matrix[m-1][n-1]       # largest value is the bottom-right corner

        while low <= high:
            mid = low + (high - low)//2   # avoids overflow, same as (low+high)//2
            count = self.getcount(matrix, m, n, mid)  # how many elements are <= mid
            if count < k:
                low = mid + 1     # too few elements, answer must be larger than mid
            else:
                high = mid - 1    # enough elements, mid might be the answer, try smaller
        return low                # smallest value with count >= k

    def getcount(self, matrix, m, n, target):
        count = 0
        for i in range(m):
            # each row is sorted, so binary search gives its count of elements <= target
            count += self.binarysearch(matrix[i], target)
        return count

    def binarysearch(self, row, target):
        low, high = 0, len(row) - 1
        while low <= high:
            mid = low + (high - low)//2
            if row[mid] > target:
                high = mid - 1    # row[mid] is too big, look on the left
            else:
                low = mid + 1     # row[mid] <= target, look on the right for more
        return low    # low is the index of the first element > target,
                      # which equals the count of elements <= target