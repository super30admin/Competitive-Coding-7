Time Complexity : O(nlogn)- where n comes from iterating the rows to find count and logn for binary search
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


# Binary Search Method
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0
        
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n-1][n-1]
        print(n, low, high)
        while low < high:
            mid = (low + high) // 2
            print(mid)
            count = self.helper(matrix, mid, n)
            if count < k:
                low = mid + 1
            else:
                high = mid
                
        return low
    
    def helper(self, matrix, mid, n):
        count = 0
        j = n-1
        for i in range(n):
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count = count + j + 1
        return count
        
