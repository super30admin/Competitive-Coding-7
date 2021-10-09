"""
Time Complexity : O(nlogn) where n is the no. of elements in matrix
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # We count all the small numbers such that the mid is smaller or equal to the 
        # the number in the matrix.
        def count(matrix,mid):
            c = 0
            j = len(matrix) - 1
            for i in range(len(matrix)):
                while j>=0 and matrix[i][j] > mid:
                    j -= 1
                c += j+1
            return c
        # We find the smallest and largest numbers that the mid element and  we use             # that to set our high and low and perform binary search.
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