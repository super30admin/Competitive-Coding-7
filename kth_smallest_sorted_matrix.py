#Time Complexity: O(n log(max - min)), where max and min are the max and min values in the matrix.
#Space Complexity : O(1)
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[-1][-1]

        def countLessEqual(mid):
            count = 0
            row = n - 1
            col = 0
            while row >= 0 and col < n:
                if matrix[row][col] <= mid:
                    count += (row + 1)
                    col += 1
                else:
                    row -= 1
            return count

        while low < high:
            mid = (low + high) // 2
            if countLessEqual(mid) < k:
                low = mid + 1
            else:
                high = mid

        return low
