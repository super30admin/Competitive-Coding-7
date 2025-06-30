"""
I used binary search on the range of elements (from the smallest to the largest in the matrix). At each step, I count how many elements in the matrix are less than or equal to the current mid value. Based on this count, I adjust the search range. The point where low meets high gives the k-th smallest element.
Time Complexity: O(n log(max - min))
Space Complexity: O(1)
"""
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        def countNoOfElements(mid):
            row = len(matrix) - 1
            column = 0
            noOfElements = 0
            while row >= 0 and column < len(matrix):
                if matrix[row][column] <= mid:
                    noOfElements += row + 1
                    column += 1
                else:
                    row -= 1
            return noOfElements
        
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low < high:
            mid = low + (high - low) // 2
            count = countNoOfElements(mid) 
            if count < k:
                low = mid + 1
            else:
                high = mid
        return low       