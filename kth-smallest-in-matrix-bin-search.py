# Time Complexity: O(N∗log(max−min))
# Space Complexity: O(1)
# Approach: Use binary search to find the middle number (in the range of numbers, this might not exist in the matrix). Keep a count of the numbers less than the middle number(This can be done in O(N) using saddleback search since the rows and cols are sorted). If the count is equal K, return the smallest number greater than mid. If count is less than K, we need to increase the search space, move the start pointer to the smallest number greater than mid. If the count is greater than K, we need to reduce the search space - move the end pointer to the largest number less than mid
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        start = matrix[0][0]
        end = matrix[n-1][n-1]
        while start < end:
            mid = (start + end)//2
            smallest_gt_mid = matrix[n-1][n-1]
            largest_lt_mid = matrix[0][0]
            count, smallest_gt_mid, largest_lt_mid = \
            self.count_smaller_larger(matrix,\
                                      smallest_gt_mid,\
                                      largest_lt_mid,\
                                      mid)
            if count == k:
                return largest_lt_mid
            else:
                if count < k:
                    start = smallest_gt_mid
                else:
                    end = largest_lt_mid
        return start
            
    def count_smaller_larger(self, matrix, smallest_gt_mid, largest_lt_mid, mid):
        n = len(matrix)
        row, col = n-1, 0
        count = 0
        while row >= 0 and col < n:
            if matrix[row][col] > mid:
                smallest_gt_mid = min(smallest_gt_mid, matrix[row][col])
                row -= 1
            else:
                largest_lt_mid = max(largest_lt_mid, matrix[row][col])
                col += 1
                count += row + 1
        return count, smallest_gt_mid, largest_lt_mid