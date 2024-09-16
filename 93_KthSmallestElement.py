# Accepted on leetcode(378)
# time - O(logn), space - O(1)
class Solution:
    def kthSmallest(self, matrix, k: int) -> int:
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]
        # normal binary search
        while low < high:
            mid = low + (high - low) // 2
            # getting the number of values less than or equal to current mid
            cnt = self.getCount(matrix, mid)
            if cnt < k:
                low = mid + 1
            else:
                high = mid
        return low

    def getCount(self, matrix, mid):
        cnt = 0
        j = len(matrix) - 1
        for i in range(len(matrix)):
            # check if j >= 0 and also matrix[i][j](last element of row when j is 2) is greater then enter while loop to reduce j. Otherwise, just increase the count by 3.
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            cnt += j + 1
        return cnt