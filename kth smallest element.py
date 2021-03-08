"""
Time Complexity - O(Nlogm) where m is max-min
Space Complexity - O(1)"""
class Solution:
    def counter(self,matrix,mid,small,large):
        count = 0
        r = len(matrix)-1
        c = 0
        while(r >= 0 and c < len(matrix)):
            if matrix[r][c] > mid:
                large = min(large,matrix[r][c])
                r -= 1
            else:
                small = max(small,matrix[r][c])
                count += (r+1)
                c += 1
        return count,small,large
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0  or matrix == None or matrix[0] == None:
            return 0
        n = len(matrix)
        m = len(matrix[0])
        low = matrix[0][0]
        high = matrix[n-1][m-1]
        while(low < high):
            mid = low + (high - low)//2
            small = matrix[0][0]
            large = matrix[n - 1][m - 1]
            count,small,large = self.counter(matrix,mid,small,large)
            if count == k:
                return small
            elif count < k:
                low = large
            else:
                high = small
        return low