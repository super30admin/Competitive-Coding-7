
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n-1][n-1]
        
        while low < high:
            mid = low + (high-low)//2
            
            count = 0
            for i in range(len(matrix)):
                for j in range(len(matrix[0])):
                    if matrix[i][j] <= mid:
                        count += 1
            
            if count < k:
                low = mid + 1
            else:
                high = mid
        
        return low