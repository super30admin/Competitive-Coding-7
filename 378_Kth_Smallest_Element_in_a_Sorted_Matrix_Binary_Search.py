# Time Complexity : O(log(n * n) * (n+n)) [n = row and col size of matrix]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem approach
# 1. Perform binary search on the entire matrix with top-left element as start and bottom-right elment as end
# 2. Our aim is to land the start index at the kth largest value
# 3. For each mid, count the number of elements smaller than it 
class Solution:
    def counter(self, matrix, mid):
        n = len(matrix)
        i = 0
        j = n-1
        count = 0
        while i < n and j >= 0:
            if matrix[i][j] > mid:
                j-=1
            else:
                count+=j+1
                i+=1
        return count
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:return 0
        n = len(matrix)
        start = matrix[0][0]
        end = matrix[n-1][n-1]
        
        while start < end:
            mid = start + (end-start) // 2
            if self.counter(matrix, mid) < k:
                start = mid+1
            else:
                end = mid        
        return start