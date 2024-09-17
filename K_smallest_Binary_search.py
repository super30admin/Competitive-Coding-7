# Time complexity : O(N log k)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        self.rows = len(matrix)
        self.cols = len(matrix[0])
        
        # find rows and cols, high and low point in the matrix which is first and last element
        low = matrix[0][0]
        high = matrix[self.rows - 1][self.cols - 1]
        
        # we traverse until low and high cross each other
        while low <= high:
            mid = low + (high - low) // 2
            
            # after finding the mid element, it may or may not be present in the matrix
            curr = self.helper(matrix, mid)
            
            # if curr count is less than k, then we increment in the right half, else in the left one
            if curr < k:
                low = mid + 1
            else:
                high = mid -1
        # result would always be at low pointer
        return low
    
    # This function traverses over the matrix and find the elements which are greater than the mid we just found, if that is k, then we have our element
    def helper(self, matrix, mid):
        count = 0
        for i in range(self.rows):
            j = self.cols - 1
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count += j+1
        return count
