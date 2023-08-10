# Time Complexity: O( n^2 log k)
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We get the Kth smallest element by creating a minheap of size k and keeping track of the largest element in the heap.
We then take each row and add the element on to the heap if it is smaller than the largest element in it, if it isn't 
we move on to the next row as the rows are sorted.
"""

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if matrix == None or len(matrix) == 0: return None

        heap = []
        minimum = float('-inf')
        k = len(matrix)**2 - k + 1

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if len(heap) < k:
                    heapq.heappush(heap, (matrix[i][j], i, j))
                    if matrix[i][j] < minimum: 
                        minimum = matrix[i][j]
                else:
                    if matrix[i][j] < minimum:
                        break
                    else:
                        heapq.heappushpop(heap, (matrix[i][j], i, j))
        return heap[0][0]
