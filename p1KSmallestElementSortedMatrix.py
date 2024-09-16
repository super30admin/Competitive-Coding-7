
"""
time: NLog(A), A is max - min values
space: O(1)
"""

class Solution:
    def counts(self, matrix: List[List[int]], i: int) -> int:
        count = 0
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] <= i:
                    count += 1
        return count
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        l, h = matrix[0][0], matrix[-1][-1]
        
        while l < h:
            mid =  (l + h) // 2
            count = self.counts(matrix, mid)
            if count >= k:
                h = mid 
            else: 
                l = mid  +1 
        return l
            