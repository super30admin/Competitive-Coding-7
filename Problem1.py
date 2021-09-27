class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        def count(matrix,mid):
            c = 0
            j = len(matrix) - 1
            for i in range(len(matrix)):
                while j>=0 and matrix[i][j] > mid:
                    j -= 1
                c += j+1
            return c
            
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low < high:
            mid = low + (high-low) // 2
            c = count(matrix,mid)
            if c < k:
                low = mid + 1
            else:
                high = mid
        return low