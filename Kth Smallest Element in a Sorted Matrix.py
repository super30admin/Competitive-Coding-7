# TC: O(NlogM)
# SC: O(1)

class Solution:
    def kthSmallest(self, matrix, k: int) -> int:
        n = len(matrix)
        l = matrix[0][0]
        r = matrix[n-1][n-1]
        
        while l<r:
            mid = (l+r)//2
            small = matrix[0][0]
            large = matrix[n-1][n-1]
            
            count, small, large = self.helper(matrix,mid,small,large)
            
            if count == k:
                return small
            if count < k:
                l = large
            else:
                r = small
        return l
    
    def helper(self,matrix,mid,small,large):
        count = 0
        n = len(matrix)
        row, col = n - 1, 0
        
        while row >= 0 and col < n:
            if matrix[row][col] > mid:
                    # as matrix[row][col] is bigger than the mid, let's keep track of the
                    # smallest number greater than the mid
                large = min(large, matrix[row][col])
                row -= 1
                
            else:
                    # as matrix[row][col] is less than or equal to the mid, let's keep track of the
                    # biggest number less than or equal to the mid
                small = max(small, matrix[row][col])
                count += row + 1
                col += 1

        return count, small, large