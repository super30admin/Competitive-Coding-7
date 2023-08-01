# Time complexity : O(n * log(n))
# Space complexity : O(1)

# The code ran on Leetcode

# Initialize low and high pointers to start and end of matrix. Compute the mid and the number of elements <= mid. if this number is greater than k, move high pointer to mid. Otherwise, move low pointer to mid + 1. 

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        l = matrix[0][0]; r = matrix[n-1][n-1]; cnt = 0

        def get_cnt(matrix, mid):
            cnt = 0
            j = n-1
            for i in range(n):
                while j >= 0 and matrix[i][j] > mid:
                    j-=1
                cnt += j+1
            return cnt

        while l < r:
            mid = (l+r)//2
            cnt = get_cnt(matrix, mid)
            if cnt < k:
                l = mid + 1
            else:
                r = mid
        return l