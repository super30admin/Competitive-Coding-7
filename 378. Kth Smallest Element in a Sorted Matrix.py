T = O(nlogn)
S = O(1)

Approach:
Consider two pointers low and high and the each pointer hols the value and not the index
comupte the mid value, Now find how many numbers exist that are below the mid value if this count
is equal to the k then the low value will point to the number. if not move the values and repeat

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n-1][n-1]
        while low < high:
            mid = low+(high-low)//2
            count = self.help(matrix, mid, n)
            if count < k:
                low = mid+1
            else:
                high = mid
        return low

    def help(self, matrix, mid, n):
        count = 0
        j = n-1
        for i in range(n):
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count = count+j+1
        return count