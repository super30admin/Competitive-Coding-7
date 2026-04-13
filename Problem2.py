# 378. Kth Smallest Element in a Sorted Matrix

# Kth Smallest Element in a Sorted Matrix
import math


[[1,5,9],[10,11,13],[12,13,15]]

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        self.n = len(matrix)
        lowValue = matrix[0][0]
        HighValue = matrix[self.n-1][self.n-1]
        result = lowValue
        while lowValue < HighValue:
            midValue = (lowValue+HighValue)//2

            count = self.getLowerCount(matrix, midValue)

            if count >= k:
                result = midValue
                HighValue = midValue-1
            else:
                lowValue = midValue+1
        return result


    def getLowerCount(self, matrix, midValue):
        row = self.n -1
        colmn = 0
        count=0
        while row>=0 and colmn<self.n:
            val = matrix[row][colmn]
            if val > midValue:
                row-=1
                
            else:
                count+=(row-1)
                column+=1
        return count
