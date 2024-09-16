from heapq import *
from typing import List


class Solution:
    def kthSmallestBruteForce(self, matrix: List[List[int]], k: int) -> int:
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
            if col < cols:
                heappush(pq, (row[col], col, row))
        return number

    def kthSmallest(self, matrix, k):
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low < high:
            mid = (low + high) // 2
            counter = self._count(matrix, mid)
            if counter < k:
                low = mid + 1
            else:
                high = mid
        return low

    def _count(self, matrix, mid):
        rows = len(matrix)
        count = 0
        j = rows - 1
        for i in range(rows):
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count += j + 1
        return count


if __name__ == '__main__':
    matrix = [
        [1, 5, 9],
        [10, 11, 13],
        [12, 13, 15]
    ]
    k = 8

    print(Solution().kthSmallest(matrix, k))
