# Time Complexity: O(logm)
# Space Complexity: O(1)
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        m = len(matrix)
        n = len(matrix[0])
        low = matrix[0][0]
        high = matrix[m - 1][n - 1]

        def count(mid):
            cnt = 0
            i = n - 1
            j = 0
            while i >= 0 and j < n:
                if matrix[i][j] > mid:
                    i -= 1
                    # j=0
                else:
                    j += 1
                    cnt += (i + 1)
                    # cnt+=1
            return cnt

        while low <= high:
            mid = (low + high) // 2
            cnt = count(mid)
            if cnt < k:
                low = mid + 1
            else:
                high = mid - 1
        return low




