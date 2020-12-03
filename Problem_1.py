"""
Time Complexity : O(nlogn)- where n comes from iterating the rows to find count and logn for binary search
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, we set low as min element and high as max element and do binary search on them to find the kth smallest
element. Everytime we find the mid, we check if the number of elements smaller to it are less than or 
greater than k and accordingly shift the low or high pointer.
"""


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
