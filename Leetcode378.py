#Time Complexity = O(n log(max-min))
# Space Complexity = O(1)
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        def countElements(mid):
            j = len(matrix[0]) -1
            count = 0
            for i in range(len(matrix)):
                while j >= 0 and matrix[i][j] > mid:
                    j -= 1
                count += j +1
            return count
        left, right = matrix[0][0],matrix[-1][-1]

        while left < right:
            mid = left + (right - left)//2
            if countElements(mid) < k:
                left = mid +1
                print(left)
            else:
                right = mid 
        return left   
