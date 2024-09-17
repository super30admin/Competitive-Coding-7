# Time Complexity : O(mnlogmn)
# Space Complexity : O(1)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)

        low = matrix[0][0]
        high = matrix[m-1][m-1]

        while low < high:
            mid  = (low+high)//2

            count = self.Counter(matrix,mid)
            if count < k:
                low = mid+1
            else:
                high = mid

        return low

    def Counter(self,matrix,mid):
        m = len(matrix)
        count = 0

        for i in range(m):
            j = m - 1
            while j>=0 and matrix[i][j] > mid:
                j -= 1
            count += (j+1)
        return count