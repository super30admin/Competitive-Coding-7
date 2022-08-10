"""
Runtime Complexity: O(N * log(max-min)). Where N is the number of time we perform the operation, and we always do a binary search in the range between max and min. Therefore will be going log(max-min) levels all the time we perform a binary search. Since we do this for N times by reducing the range, the overall time complexity is O(N* log(max-min)).
Space Complexity:O(1)- since we did not use any data structures to compute the solution. We use two pointers left and right to search within the range.
Yes, the code worked on leetcode.
Issues while coding - No
"""

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        left,right,N = matrix[0][0], matrix[-1][-1], len(matrix)
        
        def less_than_k(m):
            count = 0
            for r in range(N):
                x = bisect_right(matrix[r],m)
                count+=x
            return count
        while left<=right:
            mid = (left+right)//2
            if less_than_k(mid)<k:
                left = mid+1
            else:
                right = mid-1
        return left
            
            
        