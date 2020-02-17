from heapq import *
from typing import List


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        """
            Time Complexity - O(min(k,N)+K*logN)
            Space Complexity - O(K)
            Three lines explanation -
                - Add k rows in the priority queue
                - Pop each element from the row and increment
                  column (if we still have for the cur row)
                  till we reach the k'th element.
        """
        # edge case
        if not matrix:
            return -1

        pq = []
        rows = len(matrix)
        cols = len(matrix[0])

        # put the 1st element of each row in the min heap
        # we don't need to push more than 'k' elements in the heap
        for row in range(min(k, rows)):
            # first element in the row
            # current column
            # row elements
            heappush(pq, (matrix[row][0], 0, matrix[row]))

        # take the smallest(top) element form the min heap, if the running count is equal to k' return the number
        # if the row of the top element has more elements, add the next element to the heap
        numberCount, number = 0, 0
        while pq:
            number, col, row = heappop(pq)
            numberCount += 1
            if numberCount == k:
                break
            # if we still have elements in the current row
            col += 1
            if cols > col:
                heappush(pq, (row[col], col, row))
        return number

    def kthSmallest(self, matrix, k):
        n = len(matrix)
        start, end = matrix[0][0], matrix[n - 1][n - 1]
        while start < end:
            mid = start + (end - start) / 2
            smaller, larger = (matrix[0][0], matrix[n - 1][n - 1])

            count, smaller, larger = self.count_less_equal(matrix, mid, smaller, larger)

            if count == k:
                return smaller
            if count < k:
                start = larger  # search higher
            else:
                end = smaller  # search lower

        return start

    def count_less_equal(self, matrix, mid, smaller, larger):
        count, n = 0, len(matrix)
        row, col = n - 1, 0
        while row >= 0 and col < n:
            if matrix[row][col] > mid:
                # as matrix[row][col] is bigger than the mid, let's keep track of the
                # smallest number greater than the mid
                larger = min(larger, matrix[row][col])
                row -= 1
            else:
                # as matrix[row][col] is less than or equal to the mid, let's keep track of the
                # biggest number less than or equal to the mid
                smaller = max(smaller, matrix[row][col])
                count += row + 1
                col += 1

        return count, smaller, larger


if __name__ == '__main__':
    matrix = [
        [1, 5, 9],
        [10, 11, 13],
        [12, 13, 15]
    ]
    k = 8

    print(Solution().kthSmallest(matrix, k))
    print(Solution().find_Kth_smallest(matrix, k))
