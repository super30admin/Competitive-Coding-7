#Time Complexity:- O(nlog(max-min))
#Space Complexity:- O(1)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n-1][n-1]

        while low < high:
            mid = (low+high)//2
            counter = self.count(mid, matrix)
            if counter <k:
                low =mid+1
            else:
                high = mid
        return low


    def count(self, mid, matrix):
        j = len(matrix)-1
        countValues = 0
        for i in range(len(matrix)):
            while j>=0 and matrix[i][j] > mid:
                j-=1
            countValues +=j+1
        return countValues

        