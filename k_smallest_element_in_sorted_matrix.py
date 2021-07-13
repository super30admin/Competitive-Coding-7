# Time Complexity: O(k log n)
# Space Complexity: O(n) n - where n is minimum between n and k
import heapq


class Solution:
    #     We will add all the first n or k elements in the heap (whichever is minimum)
    #    Then we will heapify given heap, for every k we will
    #    pop the element from the heap and check if current elements
    #    row and columns are in the range and if then we will push the next child of
    #    current element in the heap(here as all the row and column both are sorted
    #    and we are adding 1st column values in the heap in start then we can consider next child as next column)
    #    and till k is positive we will do operations on heap and after that we will
    #    just pop the top element in the heap
    def kthSmallest(self, matrix, k):
        heapm = []
        n = len(matrix)
        for i in range(min(n, k)):
            heapq.heappush(heapm, (matrix[i][0], i, 0))

        heapq.heapify(heapm)

        while k:
            curr, r, c = heapq.heappop(heapm)

            if c < n - 1:
                heapq.heappush(heapm, (matrix[r][c + 1], r, c + 1))

            k -= 1

        return curr


