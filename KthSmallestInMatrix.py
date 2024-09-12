'''
    Time Complexity:
        O(klogn) (where n = length of the matrix)

    Space Complexity:
        O(n) (where n = length of the matrix)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Put the starting elements of all the rows in a MinHeap.
        While k > 1:
            Pop from the heap and push the next element of that row to the heap.
'''

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        heap = []

        for r in range(n):
            element = matrix[r][0]
            heap.append((element, r, 0))

        heapq.heapify(heap)

        while k > 1:
            _, r, c = heapq.heappop(heap)

            if c < n - 1:
                element = matrix[r][c + 1]
                heapq.heappush(heap, (element, r, c + 1))

            k -= 1

        return heapq.heappop(heap)[0]
